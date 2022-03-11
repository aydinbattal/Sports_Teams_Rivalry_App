package com.aydinbattal.midterm_aydin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.aydinbattal.midterm_aydin.api.RetrofitInstance
import com.aydinbattal.midterm_aydin.data.Repository
import com.aydinbattal.midterm_aydin.databinding.FragmentScreen1Binding
import com.aydinbattal.midterm_aydin.models.Game
import com.aydinbattal.midterm_aydin.viewmodels.Screen1ViewModel
import com.aydinbattal.midterm_aydin.viewmodels.Screen1ViewModelFactory
import com.aydinbattal.midterm_aydin.viewmodels.Screen2ViewModel
import com.aydinbattal.midterm_aydin.viewmodels.Screen2ViewModelFactory
import kotlin.random.Random


class Screen1Fragment : Fragment(R.layout.fragment_screen1) {

    // 1. Create an instance of the API
    private val api by lazy { RetrofitInstance.retrofitService }

    // 2. Create an instance of the repository and pass it the API
    private val repository by lazy { Repository(api) }

    // view model
    private val vm: Screen1ViewModel by viewModels{
        Screen1ViewModelFactory(repository)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initialize the variable
        val binding = FragmentScreen1Binding.bind(view)



        binding.btnFight.setOnClickListener{
            vm.generateScores(binding.tvTeam1.text.toString(), binding.tvTeam2.text.toString())
            binding.tvResult.text = "Winner is: " + vm.winner
            binding.tvScore1.text = vm.team1Score.toString()
            binding.tvScore2.text = vm.team2Score.toString()

            //val id = Random.nextInt(2, 1001)
            val gameToInsert = Game(vm.team1Score,vm.team2Score,vm.winner)
            vm.addGame(gameToInsert)

        }

        binding.btnHistory.setOnClickListener{
            val action = Screen1FragmentDirections.actionScreen1FragmentToScreen2Fragment()

            findNavController().navigate(action)
        }
    }
}