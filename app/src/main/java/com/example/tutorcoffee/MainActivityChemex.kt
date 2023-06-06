package com.example.tutorcoffee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

<<<<<<<< HEAD:app/src/main/java/com/example/tutorcoffee/MainActivityAero.kt
class MainActivityAero : AppCompatActivity() {
========
class MainActivityChemex : AppCompatActivity() {
>>>>>>>> origin/list_resep_chemex:app/src/main/java/com/example/tutorcoffee/MainActivityChemex.kt

    private lateinit var newRecycleView : RecyclerView
    private lateinit var newArrayList: ArrayList<resep>
    lateinit var iconAlatId : Array<Int>
    lateinit var iconTimerId : Array<Int>
    lateinit var nama : Array<String>
    lateinit var timer : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<<< HEAD:app/src/main/java/com/example/tutorcoffee/MainActivityAero.kt
        setContentView(R.layout.activity_main_aero)
========
        setContentView(R.layout.activity_main_chemex)
>>>>>>>> origin/list_resep_chemex:app/src/main/java/com/example/tutorcoffee/MainActivityChemex.kt

        iconAlatId = arrayOf(
            R.mipmap.aeropress1_foreground,
            R.mipmap.aeropress1_foreground,
        )

        iconTimerId = arrayOf(
            R.drawable.timer,
            R.drawable.timer,
        )

        nama = arrayOf(
            "AeroPress basic recipe",
            "AeroPress brew recipe",
        )

        timer = arrayOf(
            "2:30",
            "3:00",
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
<<<<<<<< HEAD:app/src/main/java/com/example/tutorcoffee/MainActivityAero.kt
                    val intent = Intent(this@MainActivityAero,DetailResepAero::class.java)
                    startActivity(intent)
                } else if (position == 1) {
                    val intent = Intent(this@MainActivityAero, DetailResepAero2::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@MainActivityAero,"resep no. $position", Toast.LENGTH_SHORT).show()
========
                    val intent = Intent(this@MainActivityChemex,DetailResepChemex::class.java)
                    startActivity(intent)
                } else if (position == 1) {
                    val intent = Intent(this@MainActivityChemex, DetailResepChemex2::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@MainActivityChemex,"resep no. $position", Toast.LENGTH_SHORT).show()
>>>>>>>> origin/list_resep_chemex:app/src/main/java/com/example/tutorcoffee/MainActivityChemex.kt
                }
            }

        })
    }
}