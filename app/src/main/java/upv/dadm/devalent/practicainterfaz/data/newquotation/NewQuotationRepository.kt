package upv.dadm.devalent.practicainterfaz.data.newquotation

import upv.dadm.devalent.practicainterfaz.domain.model.Quotation

interface NewQuotationRepository {
    suspend fun getNewQuotation(language : String): Result<Quotation>
}