package com.aydinbattal.midterm_aydin.data

import com.aydinbattal.midterm_aydin.api.CustomAPI
import com.aydinbattal.midterm_aydin.models.Game

/**
 * Midterm-Aydin created by aydin
 * student ID : 991521740
 * on 2022-03-11 */

// functions that perform operations on your data source (api)
class Repository(val api: CustomAPI) {

    suspend fun getAllGames():List<Game> {
        return api.getGames()
    }

    suspend fun addGame(game:Game) {
        api.addGame(game)
    }
}
