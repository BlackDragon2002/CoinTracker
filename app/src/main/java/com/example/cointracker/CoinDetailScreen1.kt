package com.example.cointracker.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.cointracker.R
import com.example.cointracker.databinding.FragmentCoinDetailScreenBinding
import com.example.cointracker.models.coinDetail.Tag
import com.example.cointracker.models.coinDetail.Team
import com.example.cointracker.ui.CoinViewModel
import com.example.cointracker.ui.MainActivity
import com.example.cointracker.util.Resources
import com.example.cointracker.adapter.TeamAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.delay
import java.util.*
import kotlin.collections.ArrayList

class CoinDetailScreen1 : Fragment(R.layout.fragment_coin_detail_screen) {
//    private lateinit var binding: FragmentCoinDetailScreenBinding
//
//    private val args : CoinDetailScreenArgs by navArgs()
//
//    lateinit var teamAdapter: TeamAdapter
//
//    val TAG="error"
//    lateinit var viewModel :CoinViewModel
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding= FragmentCoinDetailScreenBinding.inflate(layoutInflater,container,false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        viewModel=(activity as MainActivity).coinViewModel
//
//        val currentCoin=args.coinDetail
//        val coinId=currentCoin.id
//        viewModel.coinDetailResponse(coinId)
//
//        setUpRecyclerView()
//        ViewCompat.setNestedScrollingEnabled(binding.rvTeam,false)
//
//        lifecycleScope.launchWhenCreated {
//
//            delay(300L)
//            viewModel.coinDetail.observe(viewLifecycleOwner, Observer { response->
//                when(response){
//                    is Resources.Success ->{
//                        response.data?.let {
//
//                            val rank=currentCoin.rank.toString()
//                            val name= it.name.toString()
//                            val symbol=it.symbol.toString()
//                            binding.tvHeader.text ="$rank) $name($symbol)"
//
//                            if(currentCoin.is_active){
//                                binding.tvActive.text="Active"
//                            }else{
//                                binding.tvActive.text="Not -Active"
//                            }
//
//                            binding.tvDescription.text=it.description.toString()
//                            val  List:List<Team> = it.team
//
//                        }
//                    }
//                }
//
//            })
//        }
//
//    }
//    fun setUpRecyclerView(){
//        teamAdapter=TeamAdapter()
//
//        binding.rvTeam.apply {
//            adapter=teamAdapter
//            layoutManager=LinearLayoutManager(activity)
//
//
//        }
//    }
}