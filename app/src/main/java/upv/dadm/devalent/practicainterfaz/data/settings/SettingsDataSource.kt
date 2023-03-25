package upv.dadm.devalent.practicainterfaz.data.settings

import kotlinx.coroutines.flow.Flow


interface SettingsDataSource {
    fun getUserName() : Flow<String>
}