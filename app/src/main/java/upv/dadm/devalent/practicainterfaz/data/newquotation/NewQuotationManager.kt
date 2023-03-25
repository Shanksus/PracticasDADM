package upv.dadm.devalent.practicainterfaz.data.newquotation

import upv.dadm.devalent.practicainterfaz.domain.model.Quotation

interface NewQuotationManager {
    suspend fun getNewQuotation() : Result<Quotation>
}