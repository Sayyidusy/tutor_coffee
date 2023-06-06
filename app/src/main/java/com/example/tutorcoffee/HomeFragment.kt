package com.example.tutorcoffee

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        // Temukan referensi ke CardView
        val cardAeropress = rootView.findViewById<CardView>(R.id.card_aeropress)

        // Set listener untuk CardView
        cardAeropress.setOnClickListener {
            val intent = Intent(requireContext(), ListResepActivity::class.java)
            startActivity(intent)
        }

        return rootView
    }


}