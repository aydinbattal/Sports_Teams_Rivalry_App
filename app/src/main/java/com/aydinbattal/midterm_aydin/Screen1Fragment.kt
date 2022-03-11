package com.aydinbattal.midterm_aydin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.aydinbattal.midterm_aydin.databinding.FragmentScreen1Binding
import com.aydinbattal.midterm_aydin.viewmodels.Screen1ViewModel
import com.aydinbattal.midterm_aydin.viewmodels.Screen1ViewModelFactory


class Screen1Fragment : Fragment(R.layout.fragment_screen1) {

    // view model
    private val vm:Screen1ViewModel by viewModels{
        Screen1ViewModelFactory()
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
        }
    }
}