package com.example.cointracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cointracker.R
import com.example.cointracker.models.CoinListItem

class CoinListAdapter:RecyclerView.Adapter<CoinListAdapter.CoinListHolder>() {
    inner class CoinListHolder(itemView:View) :RecyclerView.ViewHolder(itemView)

    private val differCallBack = object :DiffUtil.ItemCallback<CoinListItem>(){
        override fun areItemsTheSame(oldItem: CoinListItem, newItem: CoinListItem): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: CoinListItem, newItem: CoinListItem): Boolean {
            return oldItem==newItem
        }
    }

    val differ=AsyncListDiffer(this,differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinListHolder {
        return CoinListHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.coin_list_layout,parent,false)
        )

    }

    override fun onBindViewHolder(holder: CoinListHolder, position: Int) {
        val currentCoin=differ.currentList[position]


        holder.itemView.apply {
            findViewById<TextView>(R.id.tv_rank).text="${currentCoin.rank}) "
            findViewById<TextView>(R.id.tv_id).text="(${currentCoin.id}) "
            findViewById<TextView>(R.id.tv_name).text=currentCoin.name
            setOnClickListener {
                onItemClickListener?.let { it(currentCoin) }
            }
        }

    }
    private var onItemClickListener : ((CoinListItem)-> Unit)?=null
    fun setOnItemCLickListener (clicked :(CoinListItem)-> Unit){
        onItemClickListener=clicked
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}