package com.example.cointracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cointracker.R
import com.example.cointracker.models.coinDetail.Team

class TeamAdapter:RecyclerView.Adapter<TeamAdapter.TeamHolder>() {
    inner class TeamHolder(view : View) :RecyclerView.ViewHolder(view)

    private val differCallBack =object :DiffUtil.ItemCallback<Team>(){
        override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem.id ==newItem.id
        }

        override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem==newItem
        }
    }
    val differ=AsyncListDiffer(this,differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        return TeamHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.team_layout,parent,false)
        )
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        val currentTeam=differ.currentList[position]
        holder.itemView.apply {
            findViewById<TextView>(R.id.tv_team_member).text=currentTeam.name
            findViewById<TextView>(R.id.tv_team_role).text=currentTeam.position
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}