package upv.dadm.devalent.practicainterfaz.data.newquotation.model

import retrofit2.Response
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation
import java.io.IOException

fun QuotationDto.toDomain() =
    Quotation(id = quoteLink, cita = quoteText, autor = quoteAuthor)

fun Response<QuotationDto>.toDomain() =
    if (isSuccessful) Result.success((body() as QuotationDto).toDomain())
    else Result.failure(IOException())