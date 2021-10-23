package com.example.cointracker.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cointracker.repository.CoinRepository

class CoinViewModelProviderFactory(
    val coinRepository: CoinRepository
) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CoinViewModel(coinRepository) as T
    }
}