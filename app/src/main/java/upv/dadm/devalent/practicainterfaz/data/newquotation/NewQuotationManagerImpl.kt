package upv.dadm.devalent.practicainterfaz.data.newquotation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import upv.dadm.devalent.practicainterfaz.data.settings.SettingsRepository
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation
import javax.inject.Inject

class NewQuotationManagerImpl @Inject constructor(
    private val settingsRepository: SettingsRepository,
    private val newQuotationRepository: NewQuotationRepository
) : NewQuotationManager {
    private lateinit var language: String

    init {
        CoroutineScope(SupervisorJob()).launch {
            settingsRepository.getLanguage().collect { languageCode ->
                language = languageCode
            }
        }
    }

    override suspend fun getNewQuotation(): Result<Quotation> =
        newQuotationRepository.getNewQuotation(language)
}