package com.example.tutorcoffee.addstep

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorcoffee.R
import com.example.tutorcoffee.databinding.ActivityNewResepBinding
import com.example.tutorcoffee.databinding.AddStepBinding
import com.example.tutorcoffee.databinding.FragmentAddRecipesBinding
import com.example.tutorcoffee.databinding.FragmentResultAddRecipesBinding
import com.example.tutorcoffee.step.MainActivityStep

class ResultAddRecipesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewResepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewResepBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonMakeCoffee.setOnClickListener {
            val intent = Intent(this, MainActivityStep::class.java)
            startActivity(intent)
        }

    }
}