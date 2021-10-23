package com.example.cointracker.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cointracker.models.CoinList
import com.example.cointracker.models.CoinListItem
import com.example.cointracker.models.coinDetail.CoinDetail
import com.example.cointracker.repository.CoinRepository
import com.example.cointracker.util.Resources
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response


class CoinViewModel(
    private val coinRepository: CoinRepository
) :ViewModel(){

    val coinList: MutableLiveData<Resources<CoinList>> = MutableLiveData()

    val coinDetail :MutableLiveData<Resources<CoinDetail>> = MutableLiveData()

    init {
        coinListResponse()
    }

    private fun  coinListResponse() =viewModelScope.launch {
        val response = coinRepository.getCoinList()
        coinList.postValue(handleCoinListResponse(response))
    }

    private fun handleCoinListResponse(response: Response<CoinList>) :Resources<CoinList>{
        if(response.isSuccessful){
            response.body()?.let {resultResponse ->
                return Resources.Success(resultResponse)
            }
        }
        return Resources.Error(response.message())
    }
      fun coinDetailResponse(coinId:String)=viewModelScope.launch {
        val response=coinRepository.getCoinDetail(coinId)
        coinDetail.postValue(handleCoinDetail(response))
    }
    //suspend fun coinDetail(coinId:String)=coinRepository.getCoinDetail(coinId)
    private fun handleCoinDetail(response: Response<CoinDetail>) :Resources<CoinDetail>{
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resources.Success(resultResponse)
            }
        }
        return Resources.Error(response.message())
    }


}