package upv.dadm.devalent.practicainterfaz.data.newquotation

import upv.dadm.devalent.practicainterfaz.R
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation
import javax.inject.Inject
import kotlin.random.Random

class NewQuotationRepositoryImpl @Inject constructor() : NewQuotationRepository{
    override suspend fun getNewQuotation(): Result<Quotation> {
        return if ((0..99).random() < 90) {
            val num = (0..99).random().toString()
            val quotation = Quotation(num, "Quotation text #$num", "Author #$num")
            Result.success(quotation)
        } else {
            Result.failure(Exception())
        }
    }
}