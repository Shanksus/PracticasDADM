package upv.dadm.devalent.practicainterfaz.data.newquotation

import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import upv.dadm.devalent.practicainterfaz.data.newquotation.model.QuotationDto
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation
import javax.inject.Inject

class NewQuotationDataSourceImpl @Inject constructor(var retrofit: Retrofit) : NewQuotationDataSource {
    interface NewQuotationRetrofit {
        @GET("api/1.0/?method=getQuote&format=json&lang=en")
        fun getQuotation(): Response<QuotationDto>

        private val retrofitQuotationService =
            retrofit.create(NewQuotationRetrofit::class.java)
    }

    override suspend fun getQuotation(): Response<QuotationDto> {
        return if ((0..99).random() < 90) {
            val num = (0..99).random().toString()
            val quotation = Quotation(num, "Quotation text #$num", "Author #$num")
            Result.success(quotation)
        } else {
            Result.failure(Exception())
        }
    }
}