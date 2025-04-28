//package com.example.qqclone2
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class MessageAdapter(private val messageList: List<Message>) :
//    RecyclerView.Adapter<MessageAdapter.ViewHolder>() {
//
//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val avatar: ImageView = view.findViewById(R.id.avatar)
//        val name: TextView = view.findViewById(R.id.name)
//        val lastMessage: TextView = view.findViewById(R.id.last_message)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_message, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val message = messageList[position]
//        holder.avatar.setImageResource(message.avatarResId)
//        holder.name.text = message.name
//        holder.lastMessage.text = message.lastMessage
//    }
//
//    override fun getItemCount() = messageList.size
//}
package com.example.qqclone2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter(
    private val messages: List<Message>,
    private val onClick: (Message) -> Unit // 点击消息时的回调
) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    // ViewHolder 用于缓存视图
    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.findViewById(R.id.avatar)
        val username: TextView = itemView.findViewById(R.id.name)
        val lastMessage: TextView = itemView.findViewById(R.id.last_message)
        val lastTime:TextView = itemView.findViewById(R.id.last_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.avatar.setImageResource(message.avatarResId)
        holder.username.text = message.name
        holder.lastMessage.text = message.lastMessage
        holder.lastTime.text = message.lastTime
        // 设置点击事件
        holder.itemView.setOnClickListener {
            onClick(message)
        }
    }

    override fun getItemCount(): Int = messages.size
}
