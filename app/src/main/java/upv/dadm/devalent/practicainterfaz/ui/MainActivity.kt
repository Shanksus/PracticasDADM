package upv.dadm.devalent.practicainterfaz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import upv.dadm.devalent.practicainterfaz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = binding.fragmentContainer.getFragment<NavHostFragment>().navController
        binding.bnNavigation.setupWithNavController(navController)
    }


}