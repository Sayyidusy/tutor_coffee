package com.example.tutorcoffee

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tutorcoffee.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var username: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.cardAeropress.setOnClickListener {
            val intent = Intent(requireContext(), ListResepActivity::class.java)
            intent.putExtra("cardId", R.id.card_aeropress)
            startActivity(intent)
        }

        binding.cardFrenchPress.setOnClickListener {
            val intent = Intent(requireContext(), ListResepActivity::class.java)
            intent.putExtra("cardId", R.id.card_frenchPress)
            startActivity(intent)
        }

        binding.cardChemex.setOnClickListener {
            val intent = Intent(requireContext(), ListResepActivity::class.java)
            intent.putExtra("cardId", R.id.card_chemex)
            startActivity(intent)
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username = arguments?.getString("username")
        binding.tvUsername.text = username
    }



    companion object {
        fun newInstance(username: String): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            args.putString("username", username)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = it.getString("username")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
