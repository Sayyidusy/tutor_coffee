package com.example.tutorcoffee.aero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tutorcoffee.R
import com.example.tutorcoffee.databinding.ActivityDetailResepAeroBinding

class DetailResepAero : AppCompatActivity() {

    private lateinit var binding: ActivityDetailResepAeroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailResepAeroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.favorite.setOnCheckedChangeListener { checkBox, isChecked ->
            val msg = "Item Add To Favorite " + if (isChecked) "checked" else "unchecked"
            Toast.makeText(this@DetailResepAero, msg, Toast.LENGTH_SHORT).show()

        }
    }
}