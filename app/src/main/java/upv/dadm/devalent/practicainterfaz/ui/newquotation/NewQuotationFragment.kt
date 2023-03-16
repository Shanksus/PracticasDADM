package upv.dadm.devalent.practicainterfaz.ui.newquotation

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import upv.dadm.devalent.practicainterfaz.R
import upv.dadm.devalent.practicainterfaz.databinding.FragmentNewQuotationBinding
import upv.dadm.devalent.practicainterfaz.utils.NoInternetException

@AndroidEntryPoint
class NewQuotationFragment : Fragment(R.layout.fragment_new_quotation), MenuProvider {
    private var _binding: FragmentNewQuotationBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NewQuotationViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewQuotationBinding.bind(view)
        viewModel.userName.observe(viewLifecycleOwner) { userName ->
            binding.msgBienvenida.text = getString(R.string.msgBienvenida, userName)
        }
        viewModel.cita.observe(viewLifecycleOwner) { cita ->
            binding.msgCita.text = cita.cita
            if (cita.autor == "") {
                binding.msgAutor.text = "Anonymous"
            } else {
                binding.msgAutor.text = cita.autor
            }
        }

        viewModel.isRefreshing.observe(viewLifecycleOwner) { isRefreshing ->
            binding.swipeRefreshLayout.isRefreshing = isRefreshing
        }

        viewModel.isGreetingsVisible.observe(viewLifecycleOwner) {
            binding.msgBienvenida.visibility = if (it) View.VISIBLE else View.INVISIBLE
        }

        binding.swipeRefreshLayout.setOnRefreshListener { getNewQuotation() }

        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        viewModel.showingButton.observe(viewLifecycleOwner) {
            binding.fbAnyadirFav.visibility = if (it) View.VISIBLE else View.INVISIBLE
        }

        binding.fbAnyadirFav.setOnClickListener {
            viewModel.addToFavourites()
        }

        viewModel.repositoryError.observe(viewLifecycleOwner) { error ->
            if (error != null) {
                when (error) {
                    is NoInternetException -> {
                        Snackbar.make(
                            binding.root,
                            R.string.internetException,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                    else -> {
                        Snackbar.make(
                            binding.root,
                            R.string.quotationException,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }
                viewModel.resetError()
            }

        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_new_quotation, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.refresh -> {
                getNewQuotation()
                true
            }
            else -> {
                false
            }
        }
    }

    private fun getNewQuotation() {
        viewModel.getNewQuotation()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
