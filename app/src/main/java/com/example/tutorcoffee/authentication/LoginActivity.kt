package com.example.tutorcoffee.authentication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.tutorcoffee.MainActivity
import com.example.tutorcoffee.R
import com.example.tutorcoffee.databinding.ActivityLoginBinding
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable

@SuppressLint("CheckResult")
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // username validation

        //Kondisi kalau username kosong
        val usernameStream = RxTextView.textChanges(binding.etEmail )
            .skipInitialValue()
            .map { username ->
                username.isEmpty()
            }
        usernameStream.subscribe {
            showTextMinimalAlert(it, "Email/Username")
        }

        // password validation
        val passwordStream = RxTextView.textChanges(binding.etPassword)
            .skipInitialValue()
            .map { password ->
                password.isEmpty()
            }
        passwordStream.subscribe {
            showTextMinimalAlert(it, "Password")
        }


        //Button Enable True or False
        val invalidFieldStream = Observable.combineLatest(
            usernameStream,
            passwordStream,
            { usernameInvalid: Boolean,
              passwordInvalid: Boolean ->
                !usernameInvalid && !passwordInvalid
            })

        invalidFieldStream.subscribe { isValid ->
            if(isValid){
                binding.btnSignin.isEnabled = true
                binding.btnSignin.backgroundTintList = ContextCompat.getColorStateList(this, R.color.dark_cream)
            }else{
                binding.btnSignin.isEnabled = false
                binding.btnSignin.backgroundTintList = ContextCompat.getColorStateList(this, android.R.color.darker_gray)
            }
        }


        // Click
        binding.btnSignin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        binding.tvHaventAccount.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun showTextMinimalAlert(isNotValid:Boolean, text:String){
        if (text == "Email/Username")
            binding.etEmail.error = if (isNotValid) "$text can't be empty!" else null
        else if (text == "Password")
            binding.etPassword.error = if (isNotValid) "$text can't be empty!" else null
    }
}