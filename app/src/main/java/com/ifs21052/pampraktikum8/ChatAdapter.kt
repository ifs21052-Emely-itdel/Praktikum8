package com.ifs21052.pampraktikum8

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21052.pampraktikum8.databinding.ItemRowChatBinding

class ChatAdapter {
    class ChatAdapter(private val listChat: ArrayList<ListChat>) :
        RecyclerView.Adapter<ChatAdapter.ListViewHolder>() {
        private lateinit var onItemClickCallback: OnItemClickCallback
        fun setOnItemClickCallback(onItemClickCallback:
                                   OnItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback
        }
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType:
        Int): ListViewHolder {
            val binding =
                ItemRowChatBinding.inflate(
                    LayoutInflater.from(viewGroup.context),
                    viewGroup, false)
            return ListViewHolder(binding)
        }
        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: ListViewHolder, position:
        Int) {
            val chat = listChat[position]
            holder.binding.ivSenderAvatar.setImageResource(chat.propic)
            holder.binding.tvSenderName.text = chat.username
            holder.binding.tvMessageContent.text = chat.message
            holder.binding.tvMessageTime.text = chat.time
            holder.itemView.setOnClickListener {
                onItemClickCallback
                    .onItemClicked(listChat[holder.adapterPosition])
            }
        }
        override fun getItemCount(): Int = listChat.size
        class ListViewHolder(var binding: ItemRowChatBinding) :
            RecyclerView.ViewHolder(binding.root)
        interface OnItemClickCallback {
            fun onItemClicked(data: ListChat)
        }
    }

}