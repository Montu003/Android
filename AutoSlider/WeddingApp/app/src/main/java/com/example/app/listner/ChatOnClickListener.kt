package com.example.app.listner

import com.example.app.database.entity.FirebaseTestUser

interface ChatOnClickListener {


    fun OnChatCardClicked(pos:Int,chat: FirebaseTestUser)
}