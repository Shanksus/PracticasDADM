package upv.dadm.devalent.practicainterfaz.data.newquotation

import upv.dadm.devalent.practicainterfaz.data.newquotation.model.toDomain
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation
import upv.dadm.devalent.practicainterfaz.utils.NoInternetException
import upv.dadm.devalent.practicainterfaz.utils.UnknownLanguageException
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject constructor(
    var newQuotationDataSource: NewQuotationDataSource,
    var connectivityChecker: ConnectivityChecker,
) : NewQuotationRepository {
    override suspend fun getNewQuotation(language : String): Result<Quotation> =
        if  (connectivityChecker.isConnectionAvailable()) {
                newQuotationDataSource.getQuotation(language).toDomain()
        }
        else Result.failure(NoInternetException())

}