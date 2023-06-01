package com.example.tutorcoffee.authentication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.tutorcoffee.MainActivity
import com.example.tutorcoffee.R
import com.example.tutorcoffee.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable

@SuppressLint("CheckResult")
class RegisterActivity: AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //auth
        auth = FirebaseAuth.getInstance()

        // username validation

        //Kondisi kalau username kosong
        val usernameStream = RxTextView.textChanges(binding.etUsername)
            .skipInitialValue()
            .map { name ->
                name.isEmpty()
            }
        usernameStream.subscribe {
            showNameExistAlert(it)
        }

        // email validation

        //Kondisi kalau email kosong/tidak valid
        val emailStream = RxTextView.textChanges(binding.etEmail)
            .skipInitialValue()
            .map { email ->
               !Patterns.EMAIL_ADDRESS.matcher(email).matches()
            }
        emailStream.subscribe {
            showEmailValidAlert(it)
        }

        // password validation
        val passwordStream = RxTextView.textChanges(binding.etPassword)
            .skipInitialValue()
            .map { password ->
                password.length < 8
            }
        passwordStream.subscribe {
            showTextMinimalAlert(it, "Password")
        }

        // confirm password validation
        val passwordConfirmStream = Observable.merge(
            RxTextView.textChanges(binding.etPassword)
                .skipInitialValue()
                .map { password ->
                    password.toString() != binding.etConfirmPassword.text.toString()
                },
            RxTextView.textChanges(binding.etConfirmPassword)
                .skipInitialValue()
                .map { confirmPassword ->
                    confirmPassword.toString() != binding.etPassword.text.toString()
                })
        passwordConfirmStream.subscribe {
            showPasswordConfirmAlert(it)
        }

        //Button Enable True or False
        val invalidFieldStream = Observable.combineLatest(
            usernameStream,
            emailStream,
            passwordStream,
            passwordConfirmStream,
            { usernameInvalid: Boolean,
              emailInvalid: Boolean,
              passwordInvalid: Boolean,
              passwordConfirmInvalid: Boolean ->
                !usernameInvalid && !emailInvalid && !passwordInvalid && !passwordConfirmInvalid
            })

        invalidFieldStream.subscribe { isValid ->
           if(isValid){
               binding.btnSignup.isEnabled = true
               binding.btnSignup.backgroundTintList = ContextCompat.getColorStateList(this, R.color.dark_cream)
           }else{
               binding.btnSignup.isEnabled = false
               binding.btnSignup.backgroundTintList = ContextCompat.getColorStateList(this, android.R.color.darker_gray)
           }
        }

        // click button register
        binding.btnSignup.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            registerUser(email, password)

        }
        binding.tvHaveAccount.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun showNameExistAlert(isNotValid:Boolean){
        binding.etUsername.error = if(isNotValid) "username can't be empty!" else null
    }

    private fun showTextMinimalAlert(isNotValid:Boolean, text:String){
        if (text == "Username")
            binding.etUsername.error = if (isNotValid) "$text minimal 6 character" else null
        else if (text == "Password")
            binding.etPassword.error = if (isNotValid) "$text minimal 8 character" else null
    }

    private fun showEmailValidAlert(isNotValid:Boolean){
        binding.etEmail.error = if(isNotValid) "email not valid!" else null
    }

    private fun showPasswordConfirmAlert(isNotValid: Boolean){
        binding.etConfirmPassword.error = if(isNotValid) "password not match!" else null
    }

    private fun registerUser(emai:String, password:String){
        auth.createUserWithEmailAndPassword(emai, password)
            .addOnCompleteListener(this) {
                if(it.isSuccessful){
                    startActivity(Intent(this, MainActivity::class.java))
                    Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }


}