package upv.dadm.devalent.practicainterfaz.data.newquotation

import retrofit2.Response
import upv.dadm.devalent.practicainterfaz.data.newquotation.model.QuotationDto
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation

interface NewQuotationDataSource {
    suspend fun getQuotation(): Response<QuotationDto>
}