package upv.dadm.devalent.practicainterfaz.data.settings

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(private val settingsDataSource: SettingsDataSource) : SettingsRepository {
    override fun getUsername(): Flow<String> = settingsDataSource.getUserName()
    override fun getLanguage(): Flow<String> = settingsDataSource.getLanguage()
}