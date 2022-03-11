package com.aydinbattal.midterm_aydin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Midterm-Aydin created by aydin
 * student ID : 991521740
 * on 2022-03-10 */

class Screen1ViewModelFactory()  : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(Screen1ViewModel::class.java)) {
            return Screen1ViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}