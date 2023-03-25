package upv.dadm.devalent.practicainterfaz.ui.favourites

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import upv.dadm.devalent.practicainterfaz.data.favourites.FavouritesRepository
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(favouritesRepository: FavouritesRepository) : ViewModel() {

    val listaFavs: LiveData<List<Quotation>> = favouritesRepository.getAllQuotations().asLiveData()

    val isDeleteAllVisible = listaFavs.map { it.isNotEmpty() }


    fun deleteAllQuotations() {
        //_listaFavs.value = emptyList()
    }

    fun deleteQuotationAtPosition(position: Int) {
        /*
        val listaNueva = _listaFavs.value?.toMutableList()
        listaNueva?.removeAt(position)
        _listaFavs.value = listaNueva!!
         */
    }

}