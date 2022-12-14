package com.aydinbattal.midterm_aydin.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aydinbattal.midterm_aydin.api.CustomAPI
import com.aydinbattal.midterm_aydin.data.Repository
import com.aydinbattal.midterm_aydin.models.Game
import kotlinx.coroutines.launch
import kotlin.random.Random

/**
 * Midterm-Aydin created by aydin
 * student ID : 991521740
 * on 2022-03-10 */
class Screen1ViewModel(val repo: Repository): ViewModel() {
    var team1Score: Int = 0
    var team2Score: Int = 0
    var winner: String = ""

    fun generateScores(team1Name:String, team2Name:String){
        team1Score = Random.nextInt(50, 101)
        team2Score = Random.nextInt(50, 101)

        if (team1Score > team2Score){
            winner = team1Name

        } else if (team2Score > team1Score){
            winner = team2Name

        } else {
            winner = team1Name
        }
    }

    fun addGame(game: Game) {
        viewModelScope.launch {
            try {
                val insertedGame = repo.addGame(game)
                Log.d("ABC", "Inserted a game ${insertedGame}")
            } catch (e:Exception) {
                Log.d("ABC", "Error occured: ${e.message}")
            }
        }
    }

}