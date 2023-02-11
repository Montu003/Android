package com.example.vegi.model

import android.os.Parcel
import android.os.Parcelable

data class OrderListModel(
    var orderId:String,
    var count:String,
    var status:String,
    var price:String,
    var date:String

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(orderId)
        parcel.writeString(count)
        parcel.writeString(status)
        parcel.writeString(price)
        parcel.writeString(date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OrderListModel> {
        override fun createFromParcel(parcel: Parcel): OrderListModel {
            return OrderListModel(parcel)
        }

        override fun newArray(size: Int): Array<OrderListModel?> {
            return arrayOfNulls(size)
        }
    }
}
