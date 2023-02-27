package upv.dadm.devalent.practicainterfaz.ui.newquotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewQuotationViewModel : ViewModel() {

    private val userNamePrivate = MutableLiveData<String>(getUserName())

    private fun getUserName() = setOf("Alice", "Bob", "Charlie", "David", "Emma").random()

    val userName : LiveData<String> = userNamePrivate
}