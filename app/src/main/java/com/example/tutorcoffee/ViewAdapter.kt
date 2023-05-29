package com.example.tutorcoffee

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class ViewAdapter (private val resep : ArrayList<resep>) :
    RecyclerView.Adapter<ViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_resep, parent, false)
        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return resep.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = resep[position]
        holder.iconAlat.setImageResource(currentItem.iconAlat)
        holder.namaResep.text = currentItem.nama
        holder.tanggal.text = currentItem.tanggal
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val iconAlat : ShapeableImageView = itemView.findViewById(R.id.iconAlat)

        val namaResep : TextView = itemView.findViewById(R.id.namaResep)
        val tanggal : TextView = itemView.findViewById(R.id.tanggal)
    }

}