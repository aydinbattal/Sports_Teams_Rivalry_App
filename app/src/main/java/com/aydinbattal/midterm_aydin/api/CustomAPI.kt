package com.aydinbattal.midterm_aydin.api

import com.aydinbattal.midterm_aydin.models.Game
import retrofit2.http.GET

/**
 * Midterm-Aydin created by aydin
 * student ID : 991521740
 * on 2022-03-10 */
interface CustomAPI {
    @GET("/games")
    suspend fun getGames():List<Game>
}