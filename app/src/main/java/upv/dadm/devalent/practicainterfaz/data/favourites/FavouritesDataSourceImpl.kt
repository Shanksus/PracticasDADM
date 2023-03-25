package upv.dadm.devalent.practicainterfaz.data.favourites

import kotlinx.coroutines.flow.Flow
import upv.dadm.devalent.practicainterfaz.data.favourites.model.QuotationDto
import javax.inject.Inject

class FavouritesDataSourceImpl @Inject constructor(private val favouritesDao: FavouritesDao) : FavouritesDataSource {
    override suspend fun insertQuotation(quotation: QuotationDto) {
        favouritesDao.insertQuotation(quotation)
    }

    override suspend fun deleteQuotation(quotation: QuotationDto) {
        favouritesDao.deleteQuotation(quotation)
    }

    override fun getAllQuotations(): Flow<List<QuotationDto>> =
        favouritesDao.getAllQuotations()

    override fun getQuotationById(id: String): Flow<QuotationDto> =
        favouritesDao.getQuotationById(id)

    override suspend fun deleteAllQuotations() {
        favouritesDao.deleteAllQuotations()
    }
}