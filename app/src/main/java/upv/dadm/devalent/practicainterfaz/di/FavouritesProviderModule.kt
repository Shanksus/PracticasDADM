package upv.dadm.devalent.practicainterfaz.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import upv.dadm.devalent.practicainterfaz.data.favourites.FavouritesContract
import upv.dadm.devalent.practicainterfaz.data.favourites.FavouritesDao
import upv.dadm.devalent.practicainterfaz.data.favourites.FavouritesDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FavouritesProviderModule {
    @Provides
    @Singleton
    fun provideFavouriteDataBase(@ApplicationContext context: Context): FavouritesDatabase {
        return Room.databaseBuilder(
            context,
            FavouritesDatabase::class.java,
            FavouritesContract.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideFavouritesDao(favouritesDatabase: FavouritesDatabase) : FavouritesDao = favouritesDatabase.favouritesDao()
}
