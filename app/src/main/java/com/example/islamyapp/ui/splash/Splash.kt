package com.example.islamyapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.islamyapp.R
import com.example.islamyapp.ui.home.HomeActivity

class Splash : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startHomeActivity()
    }

    private fun startHomeActivity() {
        Handler(Looper.getMainLooper())
            .postDelayed({
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
                finish()
        },2000)
    }
}