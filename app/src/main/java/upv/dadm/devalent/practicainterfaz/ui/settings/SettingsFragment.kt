package upv.dadm.devalent.practicainterfaz.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat
import upv.dadm.devalent.practicainterfaz.R
import upv.dadm.devalent.practicainterfaz.databinding.FragmentSettingsBinding

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_settings, rootKey)
    }
}
