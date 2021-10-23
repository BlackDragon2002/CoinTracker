package com.example.cointracker.models.coinDetail

import java.io.Serializable

data class CoinDetail(
    val description: String,
    val id: String,
    val message: String,
    val name: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<Team>,
    val type: String,
) :Serializable