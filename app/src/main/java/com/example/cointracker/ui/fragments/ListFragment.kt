package com.example.cointracker.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cointracker.R
import com.example.cointracker.adapter.CoinListAdapter
import com.example.cointracker.databinding.FragmentListBinding
import com.example.cointracker.models.CoinListItem
import com.example.cointracker.ui.CoinViewModel
import com.example.cointracker.ui.MainActivity
import com.example.cointracker.util.Resources


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    lateinit var coinAdapter: CoinListAdapter

    lateinit var viewModel: CoinViewModel

    var searchList= arrayListOf<CoinListItem>()
    val TAG="ListFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding= FragmentListBinding.inflate(layoutInflater,container,false)
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=(activity as MainActivity).coinViewModel

        (activity as MainActivity).supportActionBar?.show()
        setUpRecyclerView()

        coinAdapter.setOnItemCLickListener {

            val bundle=Bundle().apply {
                putSerializable("coinDetail",it)
            }

            findNavController().navigate(
                R.id.action_listFragment_to_coinDetailScreen,
                bundle
            )

        }
        viewModel.coinList.observe(viewLifecycleOwner, Observer {response ->
            when(response){
                is Resources.Success ->{

                    response.data?.let {
                        searchList=it
                        Log.e(TAG, "$it")
                        coinAdapter.differ.submitList(it)

                    }
                }
            }
        })

    }
    fun setUpRecyclerView(){
        coinAdapter= CoinListAdapter()
        binding.rvCoinList.apply {
            adapter=coinAdapter
            layoutManager=LinearLayoutManager(activity)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu,menu)
        val item=menu.findItem(R.id.search_coin)
        val searchView=item?.actionView as SearchView
        searchView.queryHint="Enter Your Text"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                onFiltering(p0)
                return true
            }
        })


        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun onFiltering(searchQuery: String?) {
        val filterList= arrayListOf<CoinListItem>()
        for(i in searchList){
            if(i.name.contains("$searchQuery")||i.symbol.contains("$searchQuery")){
                filterList.add(i)
            }
        }
        setUpRecyclerView()
        coinAdapter.differ.submitList(filterList)
        coinAdapter.notifyDataSetChanged()
        coinAdapter.setOnItemCLickListener {

            val bundle=Bundle().apply {
                putSerializable("coinDetail",it)
            }

            findNavController().navigate(
                R.id.action_listFragment_to_coinDetailScreen,
                bundle
            )

        }
    }


}



