package com.example.vegi.model

import android.os.Parcel
import android.os.Parcelable

data class First(
    var id:Int,
    var image:Int,
    var title:String,
    var price:String,
    var pric:String
):
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(image)
        parcel.writeString(title)
        parcel.writeString(price)
        parcel.writeString(pric)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<First> {
        override fun createFromParcel(parcel: Parcel): First {
            return First(parcel)
        }

        override fun newArray(size: Int): Array<First?> {
            return arrayOfNulls(size)
        }
    }
}