package upv.dadm.devalent.practicainterfaz.ui.newquotation

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import upv.dadm.devalent.practicainterfaz.data.newquotation.NewQuotationRepository
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation
import javax.inject.Inject

@HiltViewModel
class NewQuotationViewModel @Inject constructor(var newQuotationRepository: NewQuotationRepository) :
    ViewModel() {

    private val _userName = MutableLiveData<String>(getUserName())
    private fun getUserName() = setOf("Alice", "Bob", "Charlie", "David", "Emma").random()
    val userName: LiveData<String> = _userName

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
        //val num = (0..99).random().toString()
        //_cita.value = Quotation(num, "Quotation text #$num", "Author #$num")

        viewModelScope.launch {
            newQuotationRepository.getNewQuotation().fold(onSuccess = {
                _cita.value = it
            }, onFailure = { _repositoryError.value = it})
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