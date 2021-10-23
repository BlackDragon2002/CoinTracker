package com.example.cointracker.models

import java.io.Serializable

data class CoinListItem(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
) :Serializable