package com.example.cointracker.repository

import com.example.cointracker.api.RetrofitInstance

class CoinRepository {

    suspend fun getCoinList() =RetrofitInstance.api.getCoins()

    suspend fun getCoinDetail(coinId:String)=RetrofitInstance.api.getCoinById(coinId)

}