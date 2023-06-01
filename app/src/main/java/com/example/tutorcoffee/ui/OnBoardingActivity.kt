package com.example.tutorcoffee.ui


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorcoffee.MainActivity
import com.example.tutorcoffee.authentication.LoginActivity
import com.example.tutorcoffee.databinding.ActivityOnboardBinding
import com.google.firebase.auth.FirebaseAuth


class OnBoardingActivity : AppCompatActivity(){
    private lateinit var binding: ActivityOnboardBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnGetstarted.setOnClickListener {
            // Intent untuk HomeFragment
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("destination", "home")
            startActivity(intent)
            finish()
        }

        binding.btnSignin.setOnClickListener {
           startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    override fun onStart(){
        super.onStart()
        if(auth.currentUser != null){
            Intent(this, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }

}