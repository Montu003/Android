package com.example.clickevent.listener

import android.graphics.Movie
import android.view.View
import com.example.clickevent.model.movie
import com.example.clickevent.model.phone

interface OnListItemClickListener {

    fun onCardClicked(pos:Int, movie: movie)
    fun onImageClicked(view: View, pos:Int,movie: movie)

    fun onItemLayout(view:View,pos: Int)

    fun onCardPhoneClicked(pos:Int, phone: phone)
    fun onImagephoneClicked(view: View,pos: Int,phone: phone)


}