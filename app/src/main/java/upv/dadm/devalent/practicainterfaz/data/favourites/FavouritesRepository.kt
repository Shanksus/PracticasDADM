package upv.dadm.devalent.practicainterfaz.data.favourites

import kotlinx.coroutines.flow.Flow
import upv.dadm.devalent.practicainterfaz.data.favourites.model.QuotationDto
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation

interface FavouritesRepository {
    suspend fun insertQuotation(quotation: Quotation)
    suspend fun deleteQuotation(quotation: Quotation)
    fun getAllQuotations(): Flow<List<Quotation>>
    fun getQuotationById(id: String): Flow<Quotation>
    suspend fun deleteAllQuotations()
}