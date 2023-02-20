package upv.dadm.devalent.practicainterfaz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import upv.dadm.devalent.practicainterfaz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}