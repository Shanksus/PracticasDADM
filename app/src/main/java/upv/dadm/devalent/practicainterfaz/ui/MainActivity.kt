package upv.dadm.devalent.practicainterfaz.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import upv.dadm.devalent.practicainterfaz.R
import upv.dadm.devalent.practicainterfaz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MenuProvider {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = binding.fragmentContainer.getFragment<NavHostFragment>().navController
        binding.bnNavigation as NavigationBarView
        binding.bnNavigation.setupWithNavController(navController)

        setSupportActionBar(binding.idMaterialToolBar)
        var appBarConfig = AppBarConfiguration(
            setOf(
                R.id.newQuotationFragment,
                R.id.favouritesFragment,
                R.id.settingsFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfig)

        addMenuProvider(this)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_about, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.aboutDialogFragment -> {
                findNavController(R.id.fragmentContainer).navigate(R.id.aboutDialogFragment)
                true
            }
            else -> {
                false
            }
        }

    }


}