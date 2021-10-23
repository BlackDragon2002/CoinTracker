package com.example.cointracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.cointracker.R
import com.example.cointracker.repository.CoinRepository

class MainActivity : AppCompatActivity() {

    lateinit var coinViewModel: CoinViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coinRepository=CoinRepository()
        val coinViewModelProviderFactory=CoinViewModelProviderFactory(coinRepository)
        coinViewModel=ViewModelProvider(this,coinViewModelProviderFactory).get(CoinViewModel::class.java)

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.coinNavHostFragment) as NavHostFragment
        val navController=navHostFragment.navController



    }
}