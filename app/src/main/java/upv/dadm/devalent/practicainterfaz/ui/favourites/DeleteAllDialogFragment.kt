package upv.dadm.devalent.practicainterfaz.ui.favourites

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import upv.dadm.devalent.practicainterfaz.R

class DeleteAllDialogFragment(private val listener: DeleteAllDialogListener) : DialogFragment() {
    interface DeleteAllDialogListener {
        fun onDeleteAllConfirmed()
        fun onDeleteAllCancelled()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val mensajeDialogo = AlertDialog.Builder(requireContext())
        mensajeDialogo.setTitle(R.string.tituloDialogo)
        mensajeDialogo.setMessage(R.string.mensajeDialogo)
        mensajeDialogo.setPositiveButton(R.string.botonDialogoPositivo) { _, _ ->
            listener.onDeleteAllConfirmed()
        }
        mensajeDialogo.setNegativeButton(R.string.botonDialogoNegativo) { _, _ ->
            listener.onDeleteAllCancelled()
        }
        return mensajeDialogo.create()
    }
}