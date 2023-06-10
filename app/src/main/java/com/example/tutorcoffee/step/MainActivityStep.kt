package com.example.tutorcoffee.step

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorcoffee.databinding.ActivityMainBinding
import com.example.tutorcoffee.databinding.StepByStepBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivityStep : AppCompatActivity() {
    private lateinit var binding: StepByStepBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        binding = StepByStepBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}