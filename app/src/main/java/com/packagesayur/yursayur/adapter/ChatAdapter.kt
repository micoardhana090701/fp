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
import com.packagesayur.yursayur.activities.PersonChatActivity
import com.packagesayur.yursayur.chatdata.ChatEntity
import com.packagesayur.yursayur.data.sayurdata.SayurEntity

class ChatAdapter (private val listChat: List<ChatEntity>): RecyclerView.Adapter<ChatAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImageChat: ImageView = itemView.findViewById(R.id.ivGambarChat)
        val tvNamaChat: TextView = itemView.findViewById(R.id.tvNamaChat)
        val tvJamChat: TextView = itemView.findViewById(R.id.tvJamChat)
        val tvDeskripsiChat: TextView = itemView.findViewById(R.id.tvDeskripsiChat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listChat.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val chat = listChat[position]
        Glide.with(holder.itemView.context)
            .load(chat.gambarchat)
            .apply(RequestOptions().override(100, 150))
            .into(holder.ivImageChat)
        holder.tvNamaChat.text = chat.namachat
        holder.tvDeskripsiChat.text = chat.deskripsichat
        holder.tvJamChat.text = chat.jamchat.toString()
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, PersonChatActivity::class.java)
            intent.putExtra(PersonChatActivity.EXTRA_IMAGE_CHAT, chat.gambarchat.toString())
            intent.putExtra(PersonChatActivity.EXTRA_NAME_CHAT, chat.namachat)
            intent.putExtra(PersonChatActivity.EXTRA_TIME_CHAT, chat.jamchat.toString())
            intent.putExtra(PersonChatActivity.EXTRA_DESCRIPTION_CHAT, chat.deskripsichat)
            holder.itemView.context.startActivity(intent)
        }

    }
}