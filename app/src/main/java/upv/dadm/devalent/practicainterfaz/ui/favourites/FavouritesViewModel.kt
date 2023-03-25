package upv.dadm.devalent.practicainterfaz.ui.favourites

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import upv.dadm.devalent.practicainterfaz.data.favourites.FavouritesRepository
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(private val favouritesRepository: FavouritesRepository) : ViewModel() {

    val listaFavs: LiveData<List<Quotation>> = favouritesRepository.getAllQuotations().asLiveData()

    val isDeleteAllVisible = listaFavs.map { it.isNotEmpty() }


    fun deleteAllQuotations() {
        viewModelScope.launch {
            favouritesRepository.deleteAllQuotations()
        }
    }

    fun deleteQuotationAtPosition(position: Int) {
        viewModelScope.launch {
            listaFavs.value?.toMutableList()?.get(position)?.let { favouritesRepository.deleteQuotation(it) }
        }
    }

}