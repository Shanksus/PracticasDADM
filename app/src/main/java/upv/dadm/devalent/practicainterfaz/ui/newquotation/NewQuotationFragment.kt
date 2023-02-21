package upv.dadm.devalent.practicainterfaz.ui.newquotation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import upv.dadm.devalent.practicainterfaz.R
import upv.dadm.devalent.practicainterfaz.databinding.FragmentNewQuotationBinding

class NewQuotationFragment: Fragment(R.layout.fragment_new_quotation) {
    private var _binding: FragmentNewQuotationBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewQuotationBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}