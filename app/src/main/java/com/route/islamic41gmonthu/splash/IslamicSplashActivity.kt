package com.route.islamic41gmonthu.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.route.islamic41gmonthu.R
import com.route.islamic41gmonthu.home.HomeActivity

class IslamicSplashActivity : AppCompatActivity() {
    // 1- Version Control Systems (Git) -> Github
    // 2- Islamic App
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_islamic_splash)
        Handler(Looper.getMainLooper())
            .postDelayed({
                navigateToHomeScreen()
            }, 2000)
    }

    private fun navigateToHomeScreen() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
