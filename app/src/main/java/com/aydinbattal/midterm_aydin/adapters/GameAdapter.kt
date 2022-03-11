package com.aydinbattal.midterm_aydin.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aydinbattal.midterm_aydin.databinding.CustomRowLayoutBinding
import com.aydinbattal.midterm_aydin.models.Game

/**
 * Midterm-Aydin created by aydin
 * student ID : 991521740
 * on 2022-03-10 */

class GameAdapter : ListAdapter<Game, GameAdapter.GameViewHolder>(GameAdapter.GameDiffAdapter())  {

    // view holder definition
    inner class GameViewHolder(val binding: CustomRowLayoutBinding): RecyclerView.ViewHolder(binding.root) {}

    // implement the DiffUtil class
    class GameDiffAdapter: DiffUtil.ItemCallback<Game>() {
        override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
            TODO("Implement this")
            // return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
            TODO("Implement this")
            // return oldItem == newItem
        }
    }

    // mandatory functions
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameAdapter.GameViewHolder {
        // boilerplate that you need to remember
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CustomRowLayoutBinding.inflate(layoutInflater, parent, false)
        return GameViewHolder(binding)
    }

    // specify what data should be placed in each UI element of the custom row layout
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        Log.d("ABC", "onBindViewHolder is called!")

        // 1. get the current item from the list
        val item = getItem(position)
        // 2. associate the employee's information with the UI in the row layout


        var loser = ""
        var winnerScore = 0
        var loserScore = 0

        if (item.winner.lowercase() == "tigers"){
            winnerScore = item.tigers
            loserScore = item.lions
            loser = "Lions"
            holder.binding.tvOneResultInHistory.setTextColor(Color.parseColor("#FF5722"))
        } else {
            holder.binding.tvOneResultInHistory.setTextColor(Color.parseColor("#00BCD4"))
            winnerScore = item.lions
            loserScore = item.tigers
            loser = "Tigers"
        }

        holder.binding.tvOneResultInHistory.text = item.winner + " win!"
        holder.binding.tvOneScoreInHistory.text = item.winner + ": " + winnerScore.toString() + " - " + loser + ": " + loserScore

    }
}
