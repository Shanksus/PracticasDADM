package upv.dadm.devalent.practicainterfaz.ui.newquotation

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import upv.dadm.devalent.practicainterfaz.data.newquotation.NewQuotationManager
import upv.dadm.devalent.practicainterfaz.data.newquotation.NewQuotationRepository
import upv.dadm.devalent.practicainterfaz.data.settings.SettingsRepository
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation
import javax.inject.Inject

@HiltViewModel
class NewQuotationViewModel @Inject constructor(
    var settingsRepository: SettingsRepository,
    var newQuotationManager: NewQuotationManager
) :
    ViewModel() {

    val userName: LiveData<String> = settingsRepository.getUsername().asLiveData()

    private val _cita = MutableLiveData<Quotation>()
    val cita: LiveData<Quotation> = _cita

    private val _isRefreshing = MutableLiveData<Boolean>()
    val isRefreshing: LiveData<Boolean> = _isRefreshing
    val isGreetingsVisible = cita.map { cita -> cita.id.isEmpty() }

    private val _showingButton = MutableLiveData<Boolean>()
    val showingButton: LiveData<Boolean> = _showingButton

    private val _repositoryError = MutableLiveData<Throwable?>()
    val repositoryError: LiveData<Throwable?> = _repositoryError

    init {
        _showingButton.value = false
    }

    fun getNewQuotation() {
        _isRefreshing.value = true

        viewModelScope.launch {
            newQuotationManager.getNewQuotation().fold(onSuccess = {
                _cita.value = it
            }, onFailure = { _repositoryError.value = it })
        }
        _isRefreshing.value = false
        _showingButton.value = true
    }

    fun resetError() {
        _repositoryError.value = null
    }

    fun addToFavourites() {
        _showingButton.value = false
    }
}