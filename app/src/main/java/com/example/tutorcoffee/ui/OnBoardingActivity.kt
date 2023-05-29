package com.example.tutorcoffee.ui


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorcoffee.MainActivity
import com.example.tutorcoffee.authentication.LoginActivity
import com.example.tutorcoffee.databinding.ActivityOnboardBinding


class OnBoardingActivity : AppCompatActivity(){
    private lateinit var binding: ActivityOnboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetstarted.setOnClickListener {
            // Intent untuk HomeFragment
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("destination", "home")
            startActivity(intent)
            finish()
        }

        binding.btnSignin.setOnClickListener {
            // Intent untuk LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}