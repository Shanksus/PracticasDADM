package upv.dadm.devalent.practicainterfaz.data.newquotation

import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import upv.dadm.devalent.practicainterfaz.data.newquotation.model.QuotationDto
import javax.inject.Inject

class NewQuotationDataSourceImpl @Inject constructor(retrofit: Retrofit) : NewQuotationDataSource {
    interface NewQuotationRetrofit {
        @GET("api/1.0/?method=getQuote&format=json&lang=en")
        fun getQuotation(): Response<QuotationDto>
    }

    private val retrofitQuotationService = retrofit.create(NewQuotationRetrofit::class.java)

    override suspend fun getQuotation(): Response<QuotationDto> =
        try {
            retrofitQuotationService.getQuotation()
        } catch (e: Exception) {
            Response.error(
                400,
                ResponseBody.create(MediaType.parse("text/plain"), e.toString())
            )
        }

}