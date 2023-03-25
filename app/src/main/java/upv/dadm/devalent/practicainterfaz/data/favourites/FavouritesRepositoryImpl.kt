package upv.dadm.devalent.practicainterfaz.data.favourites

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import upv.dadm.devalent.practicainterfaz.data.favourites.model.toDomain
import upv.dadm.devalent.practicainterfaz.data.favourites.model.toDto
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation
import javax.inject.Inject

class FavouritesRepositoryImpl @Inject constructor(private val favouritesDataSource: FavouritesDataSource) : FavouritesRepository {
    override suspend fun insertQuotation(quotation: Quotation) {
        favouritesDataSource.insertQuotation(quotation.toDto())
    }

    override suspend fun deleteQuotation(quotation: Quotation) {
        favouritesDataSource.deleteQuotation(quotation.toDto())
    }

    override fun getAllQuotations(): Flow<List<Quotation>> {
        return favouritesDataSource.getAllQuotations().map { list ->
            list.map { dto -> dto.toDomain() }
        }
    }

    override fun getQuotationById(id: String): Flow<Quotation?> {
        return favouritesDataSource.getQuotationById(id).map { dto ->
            dto?.toDomain()
        }
    }

    override suspend fun deleteAllQuotations() {
        favouritesDataSource.deleteAllQuotations()
    }
}