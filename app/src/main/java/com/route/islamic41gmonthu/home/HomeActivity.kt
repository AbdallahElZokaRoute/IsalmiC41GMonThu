package com.route.islamic41gmonthu.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.route.islamic41gmonthu.R
import com.route.islamic41gmonthu.databinding.ActivityHomeBinding
import com.route.islamic41gmonthu.home.fragments.HadethFragment
import com.route.islamic41gmonthu.home.fragments.QuranFragment
import com.route.islamic41gmonthu.home.fragments.RadioFragment
import com.route.islamic41gmonthu.home.fragments.TasbeehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.islamicBottomNavigationView.setOnItemSelectedListener { menuItem ->
            if (menuItem.itemId == R.id.navigation_quran)
                showFragment(QuranFragment())
            else if (menuItem.itemId == R.id.navigation_hadeth)
                showFragment(HadethFragment())
            else if (menuItem.itemId == R.id.navigation_tasbeeh)
                showFragment(TasbeehFragment())
            else if (menuItem.itemId == R.id.navigation_radio)
                showFragment(RadioFragment())
            return@setOnItemSelectedListener true
        }
        binding.islamicBottomNavigationView.selectedItemId = R.id.navigation_quran
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.islamic_fragment_container, fragment)
            .commit()
    }
}
