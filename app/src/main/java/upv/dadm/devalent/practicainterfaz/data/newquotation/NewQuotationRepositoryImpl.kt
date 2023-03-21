package upv.dadm.devalent.practicainterfaz.data.newquotation

import upv.dadm.devalent.practicainterfaz.domain.model.Quotation
import upv.dadm.devalent.practicainterfaz.utils.NoInternetException
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject constructor(
    var newQuotationDataSource: NewQuotationDataSource,
    var connectivityChecker: ConnectivityChecker
) : NewQuotationRepository {
    override suspend fun getNewQuotation(): Result<Quotation> =
        if  (connectivityChecker.isConnectionAvailable()) {
            newQuotationDataSource.getQuotation()
        }
        else Result.failure(NoInternetException())

}