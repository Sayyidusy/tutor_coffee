package com.example.tutorcoffee.step

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.tutorcoffee.MainActivity
import com.example.tutorcoffee.R
import com.example.tutorcoffee.addstep.AddStepActivity
import com.example.tutorcoffee.databinding.ActivityMainBinding
import com.example.tutorcoffee.databinding.StepByStepBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivityStep : AppCompatActivity() {
    private lateinit var binding: StepByStepBinding
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        binding = StepByStepBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}