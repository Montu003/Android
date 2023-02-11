package com.app.roomcred.listner

import com.app.roomcred.database.entity.User

interface OnItemClickListner {

    fun OnUpdateRecord(user: User)
    fun OnDeleteReocrd(user: User)
}