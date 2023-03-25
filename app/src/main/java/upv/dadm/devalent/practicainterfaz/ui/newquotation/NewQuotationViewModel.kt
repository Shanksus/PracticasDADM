package upv.dadm.devalent.practicainterfaz.ui.newquotation

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import upv.dadm.devalent.practicainterfaz.data.favourites.FavouritesRepository
import upv.dadm.devalent.practicainterfaz.data.newquotation.NewQuotationManager
import upv.dadm.devalent.practicainterfaz.data.newquotation.NewQuotationRepository
import upv.dadm.devalent.practicainterfaz.data.settings.SettingsRepository
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation
import javax.inject.Inject

@HiltViewModel
class NewQuotationViewModel @Inject constructor(
    var settingsRepository: SettingsRepository,
    var newQuotationManager: NewQuotationManager,
    var favouritesRepository: FavouritesRepository
) :
    ViewModel() {

    val userName: LiveData<String> = settingsRepository.getUsername().asLiveData()

    private val _cita = MutableLiveData<Quotation>()
    val cita: LiveData<Quotation> = _cita

    private val _isRefreshing = MutableLiveData<Boolean>()
    val isRefreshing: LiveData<Boolean> = _isRefreshing
    val isGreetingsVisible = cita.map { cita -> cita.id.isEmpty() }

    val isAddToFavouritesVisible = cita.switchMap() { newQuotation ->
        favouritesRepository.getQuotationById(newQuotation.id).asLiveData()
    }.map() { favourite ->
        favourite == null
    }
    private val _repositoryError = MutableLiveData<Throwable?>()
    val repositoryError: LiveData<Throwable?> = _repositoryError

    fun getNewQuotation() {
        _isRefreshing.value = true

        viewModelScope.launch {
            newQuotationManager.getNewQuotation().fold(onSuccess = {
                _cita.value = it
            }, onFailure = { _repositoryError.value = it })
        }
        _isRefreshing.value = false
    }

    fun resetError() {
        _repositoryError.value = null
    }

    fun addToFavourites() {
        viewModelScope.launch {
            try {
                favouritesRepository.insertQuotation(cita.value!!)
            } catch (e: Exception) {
                _repositoryError.value = e
            }
        }
    }
}