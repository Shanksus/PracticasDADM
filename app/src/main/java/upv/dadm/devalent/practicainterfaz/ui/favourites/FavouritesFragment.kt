package upv.dadm.devalent.practicainterfaz.ui.favourites

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import upv.dadm.devalent.practicainterfaz.R
import upv.dadm.devalent.practicainterfaz.databinding.FragmentFavouritesBinding

class FavouritesFragment : Fragment(R.layout.fragment_favourites),
    DeleteAllDialogFragment.DeleteAllDialogListener,
    MenuProvider {
    private var _binding: FragmentFavouritesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FavouritesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavouritesBinding.bind(view)

        val adapter = QuotationListAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.listaFavs.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        viewModel.isDeleteAllVisible.observe(viewLifecycleOwner) {
            requireActivity().invalidateMenu()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDeleteAllConfirmed() {
        viewModel.deleteAllQuotations()
    }

    override fun onDeleteAllCancelled() {
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_favourites, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.item_Delete -> {
                DeleteAllDialogFragment(this).show(childFragmentManager, null)
                true
            }
            else -> {
                false
            }
        }
    }

    override fun onPrepareMenu(menu: Menu) {
        menu.findItem(R.id.item_Delete).isVisible = viewModel.isDeleteAllVisible.value ?: false
        super.onPrepareMenu(menu)
    }
}
