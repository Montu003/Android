package com.example.vegi.model

import android.os.Parcel
import android.os.Parcelable

data class MyDelivery(
    var id:Int,
    var name:String,
    var address:String,
    var content:String,
    var mobile:String,
    var pincode:String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(address)
        parcel.writeString(content)
        parcel.writeString(mobile)
        parcel.writeString(pincode)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyDelivery> {
        override fun createFromParcel(parcel: Parcel): MyDelivery {
            return MyDelivery(parcel)
        }

        override fun newArray(size: Int): Array<MyDelivery?> {
            return arrayOfNulls(size)
        }
    }
}