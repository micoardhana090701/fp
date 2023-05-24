package com.packagesayur.yursayur.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.packagesayur.yursayur.R
import com.packagesayur.yursayur.data.sayurdata.SayurEntity
import com.packagesayur.yursayur.notificationdata.NotificationEntity

class NotificationAdapter(private val listNotification: List<NotificationEntity>): RecyclerView.Adapter<NotificationAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitleNotification: TextView = itemView.findViewById(R.id.tvTitleNotification)
        val tvDescriptionNotification: TextView = itemView.findViewById(R.id.tvDescriptionNotification)
        val tvJamNotification: TextView = itemView.findViewById(R.id.tvJamNotification)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_notification, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listNotification.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val notification = listNotification[position]
        holder.tvTitleNotification.text = notification.titlenotification
        holder.tvDescriptionNotification.text = notification.descriptionnotification
        holder.tvJamNotification.text = notification.timenotification

    }
}