package upv.dadm.devalent.practicainterfaz.data.favourites.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import upv.dadm.devalent.practicainterfaz.data.favourites.FavouritesContract.entries.COLUMN_AUTHOR
import upv.dadm.devalent.practicainterfaz.data.favourites.FavouritesContract.entries.COLUMN_ID
import upv.dadm.devalent.practicainterfaz.data.favourites.FavouritesContract.entries.COLUMN_TEXT
import upv.dadm.devalent.practicainterfaz.data.favourites.FavouritesContract.entries.TABLE_NAME
import upv.dadm.devalent.practicainterfaz.domain.model.Quotation

@Entity(tableName = TABLE_NAME)
data class QuotationDto(
    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID)
    val id: String,
    @ColumnInfo(name = COLUMN_TEXT)
    val text: String,
    @ColumnInfo(name = COLUMN_AUTHOR) val author: String
) {
    /*
    companion object {
        fun fromQuotation(quotation: Quotation): QuotationDto {
            return QuotationDto(quotation.id, quotation.cita, quotation.autor)
        }
    }

    fun toQuotation(): Quotation {
        return Quotation(id, text, author)
    }
    */
}
