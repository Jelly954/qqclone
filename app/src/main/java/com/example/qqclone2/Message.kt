package com.example.qqclone2

data class Message(
    val avatarResId: Int,
    val name: String,
    val lastMessage: String,
    val lastTime: String // 新增字段，存储最后时间
)

