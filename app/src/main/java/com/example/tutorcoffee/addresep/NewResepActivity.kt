package com.example.tutorcoffee.addresep

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorcoffee.databinding.ActivityNewResepBinding
import com.example.tutorcoffee.step.MainActivityStep

class NewResepActivity : AppCompatActivity() {
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
