package com.example.tutorcoffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tutorcoffee.ListResep.ViewAdapter
import com.example.tutorcoffee.resep.resep

class ListResepActivity : AppCompatActivity() {

    private lateinit var newRecycleView : RecyclerView
    private lateinit var newArrayList: ArrayList<resep>
    lateinit var iconAlatId : Array<Int>
    lateinit var iconTimerId : Array<Int>
    lateinit var nama : Array<String>
    lateinit var timer : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_resep)

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

        var adapter = ViewAdapter(newArrayList)
        newRecycleView.adapter = adapter
        adapter.setOnItemClickListener(object : ViewAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

            }

        })
    }
}