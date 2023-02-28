package upv.dadm.devalent.practicainterfaz.ui.newquotation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import upv.dadm.devalent.practicainterfaz.R
import upv.dadm.devalent.practicainterfaz.databinding.FragmentNewQuotationBinding

class NewQuotationFragment : Fragment(R.layout.fragment_new_quotation) {
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

        viewModel.isRefreshing.observe(viewLifecycleOwner) {isRefreshing ->
            binding.swipeRefreshLayout.isRefreshing = isRefreshing
        }

        viewModel.isGreetingsVisible.observe(viewLifecycleOwner) {
            binding.msgBienvenida.visibility = if (it) View.VISIBLE else View.INVISIBLE
        }

        binding.swipeRefreshLayout.setOnRefreshListener { getNewQuotation() }
    }
    private fun getNewQuotation(){
        viewModel.getNewQuotation()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
