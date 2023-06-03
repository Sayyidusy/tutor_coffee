package com.example.tutorcoffee.user

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.tutorcoffee.authentication.LoginActivity
import com.example.tutorcoffee.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ProfileFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var userListener: ValueEventListener

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference

        val currentUser = auth.currentUser

        if (currentUser != null) {
            val userId = currentUser.uid

            // Mendapatkan data pengguna dari Realtime Database
            userListener = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val user = snapshot.getValue(User::class.java)
                    if (user != null) {
                        binding.etUsername.setText(user.username)
                        binding.etEmail.setText(user.email)
                    } else {
                        binding.etUsername.setText("Data not found")
                        binding.etEmail.setText("Data not found")
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    binding.etUsername.setText("Error: ${error.message}")
                    binding.etEmail.setText("Error: ${error.message}")
                }
            }
            database.child("users").child(userId).addValueEventListener(userListener)
        } else {
            binding.etUsername.setText("Not logged in")
            binding.etEmail.setText("Not logged in")
        }

        binding.btnLogout.setOnClickListener {
            auth.signOut()
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        if (::auth.isInitialized && auth.currentUser != null) {
            val userId = auth.currentUser!!.uid
            database.child("users").child(userId).removeEventListener(userListener)
        }
    }

}
