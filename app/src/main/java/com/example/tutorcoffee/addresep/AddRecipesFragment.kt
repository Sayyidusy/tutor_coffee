package com.example.tutorcoffee.addresep

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.tutorcoffee.R
import com.example.tutorcoffee.addstep.AddStepActivity
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class AddRecipesFragment : Fragment() {

    private lateinit var dropdownMenu: MaterialAutoCompleteTextView
    private lateinit var dropdownMenu2: MaterialAutoCompleteTextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_recipes, container, false)
        dropdownMenu = view.findViewById(R.id.method)
        dropdownMenu2 = view.findViewById(R.id.grind)

        val addStepImageView: ImageView = view.findViewById(R.id.tambah_step)
        addStepImageView.setOnClickListener {
            val intent = Intent(requireContext(), AddStepActivity::class.java)
            startActivity(intent)
        }



        // Contoh daftar pilihan
        val options = arrayOf("fine", "medium", "coarse")
        val options2 = arrayOf("fine", "medium", "coarse")

        // Buat adaptor menggunakan ArrayAdapter
        val adapter = ArrayAdapter(requireContext(), R.layout.drop_item, options)
        val adapter2 = ArrayAdapter(requireContext(), R.layout.drop_item_2, options2)

        // Set adaptor pada dropdownMenu
        dropdownMenu.setAdapter(adapter)
        dropdownMenu2.setAdapter(adapter2)

        // Atur listener untuk menangani pemilihan item dari dropdown
        dropdownMenu.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedItem = adapter.getItem(position).toString()
            val selectedItem2 = adapter2.getItem(position).toString()
            // Lakukan apa pun yang perlu dilakukan dengan item yang dipilih
            // Misalnya, tampilkan item yang dipilih dalam logcat
            println("Item yang dipilih: $selectedItem")
            println("Item yang dipilih: $selectedItem2")
        }

        return view
    }
}
