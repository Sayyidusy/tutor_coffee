package com.example.tutorcoffee.user

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorcoffee.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ProfileActivity : AppCompatActivity(){
    private lateinit var binding : FragmentProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        binding.btnSave.setOnClickListener{
            val username = binding.etUsername.text.toString()
            val email = binding.etEmail.text.toString()


            val user = User(username, email)

            if(uid != null){
                databaseReference.child(uid).setValue(user).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this@ProfileActivity, "Data saved successfully", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@ProfileActivity, "Failed to save data", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }
}