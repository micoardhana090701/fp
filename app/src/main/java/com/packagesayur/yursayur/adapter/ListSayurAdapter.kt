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
import com.packagesayur.yursayur.DetailActivity
import com.packagesayur.yursayur.R
import com.packagesayur.yursayur.data.sayurdata.SayurEntity

class ListSayurAdapter(private val listSayur: List<SayurEntity>): RecyclerView.Adapter<ListSayurAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.ivSayur)
        val tvNamaSayur: TextView = itemView.findViewById(R.id.tvNamaSayur)
        val tvHarga: TextView = itemView.findViewById(R.id.tvHarga)
        val tvRate: TextView = itemView.findViewById(R.id.tvRate)
        val tvPeople: TextView = itemView.findViewById(R.id.tvRate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.sayur_item, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSayur.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val sayur = listSayur[position]
        Glide.with(holder.itemView.context)
            .load(sayur.gambar)
            .apply(RequestOptions().override(100, 150))
            .into(holder.imgPhoto)
        holder.tvNamaSayur.text = sayur.nama
        holder.tvRate.text = sayur.rate.toString()
        holder.tvPeople.text = sayur.people.toString()
        holder.tvHarga.text = sayur.harga.toString()

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_IMAGE, sayur.gambar.toString())
            intent.putExtra(DetailActivity.EXTRA_NAME, sayur.nama)
            intent.putExtra(DetailActivity.EXTRA_RATE, sayur.rate.toString())
            intent.putExtra(DetailActivity.EXTRA_PEOPLE, sayur.people.toString())
            intent.putExtra(DetailActivity.EXTRA_HARGA, sayur.harga.toString())
            intent.putExtra(DetailActivity.EXTRA_DESKRIPSI, sayur.deskripsi)
            intent.putExtra(DetailActivity.EXTRA_IMAGETOKO, sayur.gambartoko.toString())
            intent.putExtra(DetailActivity.EXTRA_TOKO, sayur.toko)
            intent.putExtra(DetailActivity.EXTRA_STATUSES, sayur.statuses)
            intent.putExtra(DetailActivity.EXTRA_LOKASI, sayur.lokasi)
            holder.itemView.context.startActivity(intent)
        }
    }

}