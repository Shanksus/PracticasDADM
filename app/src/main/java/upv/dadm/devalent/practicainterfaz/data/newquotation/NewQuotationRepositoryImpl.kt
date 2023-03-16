package upv.dadm.devalent.practicainterfaz.data.newquotation

import upv.dadm.devalent.practicainterfaz.R
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation
import javax.inject.Inject
import kotlin.random.Random

class NewQuotationRepositoryImpl @Inject constructor(var newQuotationDataSource: NewQuotationDataSource) : NewQuotationRepository{
    override suspend fun getNewQuotation(): Result<Quotation> {
        return newQuotationDataSource.getQuotation()
    }
}