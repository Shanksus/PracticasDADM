package upv.dadm.devalent.practicainterfaz.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation

class FavouritesViewModel : ViewModel() {

    private val _listaFavs = MutableLiveData<List<Quotation>>(getFavouritesQuotation())
    val listaFavs: LiveData<List<Quotation>> = _listaFavs

    private fun getFavouritesQuotation(): List<Quotation> {
        val aux = mutableListOf<Quotation>()
        for (i in 0..19) {
            val num = (0..99).random().toString()
            aux.add(Quotation(num, "Quotation text #$num", "Author #$num"))
        }
        return aux
    }
}