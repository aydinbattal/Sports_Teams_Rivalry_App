package com.aydinbattal.midterm_aydin.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aydinbattal.midterm_aydin.api.CustomAPI
import com.aydinbattal.midterm_aydin.data.Repository
import com.aydinbattal.midterm_aydin.models.Game
import kotlinx.coroutines.launch

/**
 * Midterm-Aydin created by aydin
 * student ID : 991521740
 * on 2022-03-10 */

class Screen2ViewModel(val repo: Repository): ViewModel() {

    val gamesList:MutableLiveData<List<Game>> = MutableLiveData<List<Game>>(listOf())

    init {
        Log.d("ABC", "vm is initializing")
    }

    fun getAllGames() {
        viewModelScope.launch {
            try {
                val gamesFromAPI:List<Game> = repo.getAllGames()
                gamesList.postValue(gamesFromAPI)
                Log.d("ABC", "${gamesFromAPI}")
            } catch (e:Exception) {
                Log.d("ABC", "Error occured: ${e.message}")
            }
        }
    }
}
