package com.packagesayur.yursayur.adapter

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.packagesayur.yursayur.R
import com.packagesayur.yursayur.data.sayurdata.Message
import com.packagesayur.yursayur.databinding.ActivityRegisterBinding
import com.packagesayur.yursayur.databinding.ItemTanggapanBinding

class TanggapanAdapter(options: FirebaseRecyclerOptions<Message>, private val currentUserName: String?): FirebaseRecyclerAdapter<Message, TanggapanAdapter.MessageViewHolder>(options) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TanggapanAdapter.MessageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_tanggapan, parent, false)
        val binding = ItemTanggapanBinding.bind(view)
        return  MessageViewHolder(binding)
    }

    class MessageViewHolder(private val binding: ItemTanggapanBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Message) {
            binding.tvMessage.text = item.text
            binding.tvMessenger.text = item.email
            if (item.timestamp != null){
                binding.tvTimestamp.text = DateUtils.getRelativeTimeSpanString(item.timestamp)
            }
        }

    }

    override fun onBindViewHolder(
        holder: TanggapanAdapter.MessageViewHolder,
        position: Int,
        model: Message
    ) {
        holder.bind(model)
    }

}