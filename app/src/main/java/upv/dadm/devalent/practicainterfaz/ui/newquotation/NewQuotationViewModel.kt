package upv.dadm.devalent.practicainterfaz.ui.newquotation

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation
import javax.inject.Inject

@HiltViewModel
class NewQuotationViewModel @Inject constructor() : ViewModel() {

    private val _userName = MutableLiveData<String>(getUserName())
    private fun getUserName() = setOf("Alice", "Bob", "Charlie", "David", "Emma").random()
    val userName: LiveData<String> = _userName

    private val _cita = MutableLiveData<Quotation>()
    val cita: LiveData<Quotation> = _cita

    private val _isRefreshing = MutableLiveData<Boolean>()
    val isRefreshing: LiveData<Boolean> = _isRefreshing
    val isGreetingsVisible = cita.map { it == null }

    private val _showingButton = MutableLiveData<Boolean>()
    val showingButton: LiveData<Boolean> = _showingButton

    init {
        _showingButton.value = false
    }
    fun getNewQuotation() {
        _isRefreshing.value = true
        val num = (0..99).random().toString()
        _cita.value = Quotation(num, "Quotation text #$num", "Author #$num")
        _isRefreshing.value = false

        _showingButton.value = true
    }

    fun addToFavourites() {
        _showingButton.value = false
    }
}