package com.aydinbattal.midterm_aydin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.aydinbattal.midterm_aydin.adapters.GameAdapter
import com.aydinbattal.midterm_aydin.api.RetrofitInstance
import com.aydinbattal.midterm_aydin.data.Repository
import com.aydinbattal.midterm_aydin.databinding.FragmentScreen1Binding
import com.aydinbattal.midterm_aydin.databinding.FragmentScreen2Binding
import com.aydinbattal.midterm_aydin.viewmodels.Screen1ViewModel
import com.aydinbattal.midterm_aydin.viewmodels.Screen1ViewModelFactory
import com.aydinbattal.midterm_aydin.viewmodels.Screen2ViewModel
import com.aydinbattal.midterm_aydin.viewmodels.Screen2ViewModelFactory

class Screen2Fragment : Fragment(R.layout.fragment_screen2) {

    // 1. Create an instance of the API
    private val api by lazy { RetrofitInstance.retrofitService }

    // 2. Create an instance of the repository and pass it the API
    private val repository by lazy { Repository(api) }

    // view model
    private val vm: Screen2ViewModel by viewModels{
        Screen2ViewModelFactory(repository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initialize the variable
        val binding = FragmentScreen2Binding.bind(view)

        vm.getAllGames()

        val adapter = GameAdapter()

        // configure the layout manager for the rv
        binding.rvGamesList.layoutManager = LinearLayoutManager(context)
        // associate the rv with the adapter we created
        binding.rvGamesList.adapter = adapter

        // observer on the vm's games List
        vm.gamesList.observe(viewLifecycleOwner, Observer {
            Log.d("ABC", "Observed a change in the game list")
            Log.d("ABCD", it.toString())
            adapter.submitList(it)
        })

    }
}