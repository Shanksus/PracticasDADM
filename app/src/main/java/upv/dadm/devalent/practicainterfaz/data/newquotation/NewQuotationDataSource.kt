package upv.dadm.devalent.practicainterfaz.data.newquotation

import okhttp3.Response
import upv.dadm.devalent.practicainterfaz.data.newquotation.model.QuotationDto

interface NewQuotationDataSource {
    suspend fun getQuotation(): Response<QuotationDto>
}