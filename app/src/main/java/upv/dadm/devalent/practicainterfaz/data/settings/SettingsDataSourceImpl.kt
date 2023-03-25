package upv.dadm.devalent.practicainterfaz.data.settings

import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsDataSourceImpl @Inject constructor(private val sharedPreferences: SharedPreferences) :
    SettingsDataSource {
    companion object {
        private const val KEY_USERNAME = "username"
    }

    override fun getUserName(): Flow<String> =
        callbackFlow {
            val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
                launch(Dispatchers.IO) {
                    if (key == KEY_USERNAME) {
                        trySend(getUsernamePreference())
                    }
                }
            }
            sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
            trySend(getUsernamePreference())
            awaitClose {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
            }
        }

    private fun getUsernamePreference() = sharedPreferences.getString(KEY_USERNAME, "") ?: ""
}