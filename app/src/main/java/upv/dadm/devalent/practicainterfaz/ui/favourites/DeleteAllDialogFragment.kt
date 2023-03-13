package upv.dadm.devalent.practicainterfaz.ui.favourites

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import upv.dadm.devalent.practicainterfaz.R

@AndroidEntryPoint
class DeleteAllDialogFragment : DialogFragment() {

    private val viewModel: FavouritesViewModel by activityViewModels()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val mensajeDialogo = AlertDialog.Builder(requireContext())
        mensajeDialogo.setTitle(R.string.tituloDialogo)
        mensajeDialogo.setMessage(R.string.mensajeDialogo)
        mensajeDialogo.setPositiveButton(R.string.botonDialogoPositivo) { _, _ ->
            //viewModel.
        }
        mensajeDialogo.setNegativeButton(R.string.botonDialogoNegativo) { _, _ ->
            dismiss()
        }
        return mensajeDialogo.create()
    }
}