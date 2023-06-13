package com.example.tutorcoffee.addstep
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorcoffee.databinding.AddStepBinding

class AddStepActivity : AppCompatActivity() {
    private lateinit var binding: AddStepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddStepBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.grindCoffee.setOnClickListener {
            val intent = Intent(this, ResultAddRecipesActivity::class.java)
            startActivity(intent)
        }
    }
}