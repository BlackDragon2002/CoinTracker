package com.example.cointracker.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.cointracker.R
import com.example.cointracker.databinding.SplashScreenBinding
import kotlinx.coroutines.delay

class SplashScreen : AppCompatActivity() {
    lateinit var binding:SplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launchWhenCreated {
            delay(500L)
            startActivity(Intent(this@SplashScreen,MainActivity::class.java))
            finish()
        }
    }
}