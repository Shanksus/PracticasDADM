package upv.dadm.devalent.practicainterfaz.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import upv.dadm.devalent.practicainterfaz.data.settings.SettingsDataSource
import upv.dadm.devalent.practicainterfaz.data.settings.SettingsDataSourceImpl
import upv.dadm.devalent.practicainterfaz.data.settings.SettingsRepository
import upv.dadm.devalent.practicainterfaz.data.settings.SettingsRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsBinderModule {
    @Binds
    abstract fun bindSettingsDataSource(settingsDataSourceImpl: SettingsDataSourceImpl) : SettingsDataSource

    @Binds
    abstract fun bindSettingsRepository(settingsRepositoryImpl: SettingsRepositoryImpl) : SettingsRepository
}