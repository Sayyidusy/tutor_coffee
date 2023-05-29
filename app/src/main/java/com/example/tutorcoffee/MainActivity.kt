package com.example.tutorcoffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecycleView : RecyclerView
    private lateinit var newArrayList: ArrayList<resep>
    lateinit var iconAlatId : Array<Int>
    lateinit var nama : Array<String>
    lateinit var tanggal : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iconAlatId = arrayOf(
            R.drawable.vec_coffee_1,
            R.drawable.vec_coffee_2,
        )

        nama = arrayOf(
            "AeroPress basic recipe",
            "French Press basic recipe",
        )

        tanggal = arrayOf(
            "13-03-2023",
            "13-03-2023",
        )

        newRecycleView = findViewById(R.id.recycleView)
        newRecycleView.layoutManager = LinearLayoutManager(this)
        newRecycleView.setHasFixedSize(true)

        newArrayList = arrayListOf<resep>()
        getUserData()
    }
    private fun getUserData() {
        for (i in iconAlatId.indices){
            val resep = resep(iconAlatId[i], nama[i], tanggal[i])
            newArrayList.add(resep)
        }

        newRecycleView.adapter = ViewAdapter(newArrayList)
    }
}