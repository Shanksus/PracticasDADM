package upv.dadm.devalent.practicainterfaz.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation

class FavouritesViewModel : ViewModel() {

    private val _listaFavs = MutableLiveData<List<Quotation>>(getFavouritesQuotation())
    val listaFavs: LiveData<List<Quotation>> = _listaFavs

    val isDeleteAllVisible = Transformations.map(listaFavs) { it.isNotEmpty() }
    private fun getFavouritesQuotation(): List<Quotation> {
        val aux = mutableListOf<Quotation>()
        for (i in 0..19) {
            val num = (0..99).random().toString()
            aux.add(Quotation(num, "Quotation text #$num", "Author #$num"))
        }
        return aux
    }

    fun deleteAllQuotations() {
        _listaFavs.value = emptyList()
    }
}