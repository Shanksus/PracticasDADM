package upv.dadm.devalent.practicainterfaz.data.favourites

import kotlinx.coroutines.flow.Flow
import upv.dadm.devalent.practicainterfaz.data.favourites.model.QuotationDto

interface FavouritesDataSource {
    suspend fun insertQuotation(quotation: QuotationDto)
    suspend fun deleteQuotation(quotation: QuotationDto)
    fun getAllQuotations(): Flow<List<QuotationDto>>
    fun getQuotationById(id: String): Flow<QuotationDto>
    suspend fun deleteAllQuotations()
}