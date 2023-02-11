package com.gautam.validatonformgrewon.dao

import com.gautam.validatonformgrewon.modal.Listview

 interface ClickEventCard {

    fun onCardClicked(pos: Int, food: Listview)

}