package upv.dadm.devalent.practicainterfaz.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import dagger.hilt.android.lifecycle.HiltViewModel
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor() : ViewModel() {

    private val _listaFavs = MutableLiveData<List<Quotation>>(getFavouritesQuotation())
    val listaFavs: LiveData<List<Quotation>> = _listaFavs

    val isDeleteAllVisible = listaFavs.map { it.isNotEmpty() }
    private fun getFavouritesQuotation(): List<Quotation> {
        val aux = mutableListOf<Quotation>()
        for (i in 0..19) {
            val num = (0..99).random().toString()
            aux.add(Quotation(num, "Quotation text #$num", "Author #$num"))
        }
        aux.add(Quotation(100.toString(), "Quotation text #$100", "Albert Einstein"))
        aux.add(Quotation(101.toString(), "Quotation text #$101", "Anonymous"))
        return aux
    }

    fun deleteAllQuotations() {
        _listaFavs.value = emptyList()
    }

    fun deleteQuotationAtPosition(position: Int) {
        val listaNueva = _listaFavs.value?.toMutableList()
        listaNueva?.removeAt(position)
        _listaFavs.value = listaNueva!!
    }
}