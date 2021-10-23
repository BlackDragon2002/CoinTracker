package com.example.cointracker.api

import com.example.cointracker.models.CoinList
import com.example.cointracker.models.CoinListItem
import com.example.cointracker.models.coinDetail.CoinDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinAPI {
    @GET("/v1/coins")
    suspend fun getCoins() :Response<CoinList>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId :String) : Response<CoinDetail>
}