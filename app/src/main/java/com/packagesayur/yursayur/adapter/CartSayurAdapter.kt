package com.packagesayur.yursayur.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.packagesayur.yursayur.R
import com.packagesayur.yursayur.activities.DetailActivity
import com.packagesayur.yursayur.data.sayurdata.SayurEntity
import java.lang.Integer.min

class CartSayurAdapter (private val listSayur: List<SayurEntity>): RecyclerView.Adapter<CartSayurAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.ivGambarCart)
        val tvNamaSayur: TextView = itemView.findViewById(R.id.tvNamaSayurCart)
        val tvHarga: TextView = itemView.findViewById(R.id.tvHargaCart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return min(listSayur.size, 3)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

            val sayur = listSayur[position]
            Glide.with(holder.itemView.context)
                .load(sayur.gambar)
                .apply(RequestOptions().override(100, 150))
                .into(holder.imgPhoto)
            holder.tvNamaSayur.text = sayur.nama
            holder.tvHarga.text = sayur.harga.toString()

    }
}