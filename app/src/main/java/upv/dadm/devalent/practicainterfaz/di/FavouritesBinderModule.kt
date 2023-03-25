package upv.dadm.devalent.practicainterfaz.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import upv.dadm.devalent.practicainterfaz.data.favourites.FavouritesDataSource
import upv.dadm.devalent.practicainterfaz.data.favourites.FavouritesDataSourceImpl
import upv.dadm.devalent.practicainterfaz.data.favourites.FavouritesRepository
import upv.dadm.devalent.practicainterfaz.data.favourites.FavouritesRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class FavouritesBinderModule {
    @Binds
    abstract fun bindFavouritesDataSource(favouritesDataSourceImpl: FavouritesDataSourceImpl): FavouritesDataSource

    @Binds
    abstract fun bindFavouritesRepository(favouritesRepositoryImpl: FavouritesRepositoryImpl): FavouritesRepository
}