package com.example.qqclone2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MessageFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MessageAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_message, container, false)

        val searchBar = view.findViewById<EditText>(R.id.search_bar)
        searchBar.setOnClickListener {
            startActivity(Intent(requireContext(), SearchActivity::class.java))
        }

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val messages = listOf(
            Message(R.drawable.ic_avatar1, "乐乐", "在吗？","19:29"),
            Message(R.drawable.ic_avatar2, "六一", "明天有空吗？","19:19"),
            Message(R.drawable.ic_avatar3, "麻二", "爬山!","15:25"),
            Message(R.drawable.ic_avatar4, "小橘", "啊？","14:29"),
            Message(R.drawable.ic_avatar5, "汉堡", "吃蛋糕吗？","13:55"),
            Message(R.drawable.ic_avatar6, "花椒", "没事儿。","13:24"),
            Message(R.drawable.ic_avatar7, "张厨师", "是这样的。","13:09"),
            Message(R.drawable.ic_avatar8, "句号", "好的。","13:00"),
            Message(R.drawable.ic_avatar9, "橙莱姆", "清楚了。","10:25"),
            Message(R.drawable.ic_avatar10, "十一", "什么时候出发？","10:19"),
            Message(R.drawable.ic_avatar11, "梓涵", "收到。","09:25"),
            Message(R.drawable.ic_avatar12, "徐组", "嗯嗯。","09:24"),
            Message(R.drawable.ic_avatar13, "哈哈", "哈哈哈哈。","08:20")
        )

        adapter = MessageAdapter(messages) { message ->
            val intent = Intent(context, MessageDetailActivity::class.java)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        return view
    }
}
