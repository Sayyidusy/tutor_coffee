package com.example.tutorcoffee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivityChemex : AppCompatActivity() {

    private lateinit var newRecycleView : RecyclerView
    private lateinit var newArrayList: ArrayList<resep>
    lateinit var iconAlatId : Array<Int>
    lateinit var iconTimerId : Array<Int>
    lateinit var nama : Array<String>
    lateinit var timer : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_chemex)

        iconAlatId = arrayOf(
            R.drawable.chemex_1,
            R.drawable.chemex_1,
        )

        iconTimerId = arrayOf(
            R.drawable.timer,
            R.drawable.timer,
        )

        nama = arrayOf(
            "Chemex Brewing Tutorial",
            "Chemex Sweet And Easy",
        )

        timer = arrayOf(
            "5:30",
            "4:20",
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
               // Toast.makeText(this@MainActivity,"resep no. $position", Toast.LENGTH_SHORT).show()

                if(position == 0){
                    val intent = Intent(this@MainActivityChemex,DetailResepChemex::class.java)
                    startActivity(intent)
                } else if (position == 1) {
                    val intent = Intent(this@MainActivityChemex, DetailResepChemex2::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@MainActivityChemex,"resep no. $position", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }
}