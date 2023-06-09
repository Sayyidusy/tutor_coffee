package com.example.tutorcoffee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tutorcoffee.ListResep.ViewAdapter
import com.example.tutorcoffee.aero.DetailResepAero
import com.example.tutorcoffee.databinding.ActivityListResepBinding
import com.example.tutorcoffee.resep.resep

class ListResepActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListResepBinding
    private lateinit var newRecycleView : RecyclerView
    private lateinit var newArrayList: ArrayList<resep>
    lateinit var iconAlatId : Array<Int>
    lateinit var iconTimerId : Array<Int>
    lateinit var nama : Array<String>
    lateinit var timer : Array<String>

    private lateinit var judulList: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListResepBinding.inflate(layoutInflater)
        setContentView(binding.root)

        judulList = findViewById(R.id.judul_list)

        val cardId = intent.getIntExtra("cardId", -1)

        when (cardId) {
            R.id.card_aeropress -> judulList.text = getString(R.string.aeropress_judul)
            R.id.card_frenchPress -> judulList.text = getString(R.string.frenchpress_judul)
            R.id.card_chemex -> judulList.text = getString(R.string.chemex_judul)
        }

        iconAlatId = arrayOf(
            R.mipmap.aeropress1_foreground,
            R.mipmap.aeropress1_foreground,
            R.mipmap.aeropress1_foreground,
            R.mipmap.aeropress1_foreground,
            R.mipmap.aeropress1_foreground,
        )

        iconTimerId = arrayOf(
            R.drawable.timer,
            R.drawable.timer,
            R.drawable.timer,
            R.drawable.timer,
            R.drawable.timer,
        )

        nama = arrayOf(
            "AeroPress Basic Recipe",
            "AeroPress Brew recipe",
            "Aeropress Espresso Recipe",
            "Camping Recipe",
            "Cascara Tea in Aeropress",
        )

        timer = arrayOf(
            "2:30",
            "3:00",
            "0:50",
            "2:50",
            "8:00",
        )

        newRecycleView = findViewById(R.id.recycleView)
        newRecycleView.layoutManager = LinearLayoutManager(this)
        newRecycleView.setHasFixedSize(true)

        newArrayList = arrayListOf<resep>()
        getUserData()
    }
    private fun getUserData() {
        for (i in iconAlatId.indices){
            val resep = resep(iconAlatId[i], iconTimerId[i], nama[i], timer[i])
            newArrayList.add(resep)
        }
        val adapter = ViewAdapter(newArrayList)
        newRecycleView.adapter = adapter
        adapter.setOnItemClickListener(object : ViewAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                // Memperoleh item yang diklik dari adapter
                val clickedItem = newArrayList[position]
                // Membuat Intent ke DetailActivity
                val intent = Intent(this@ListResepActivity, DetailResepAero::class.java)
                intent.putExtra("nama", clickedItem.namaresep)
                intent.putExtra("timer", clickedItem.wakturesep)

                // Memulai DetailActivity
                startActivity(intent)
            }
        })
    }
}