package com.example.vegi.model

import android.os.Parcel
import android.os.Parcelable

data class Cartmodel(
    var id: Int,
    var img: Int,
    var name: String,
    var price:Float
):
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readFloat()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(img)
        parcel.writeString(name)
        parcel.writeFloat(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cartmodel> {
        override fun createFromParcel(parcel: Parcel): Cartmodel {
            return Cartmodel(parcel)
        }

        override fun newArray(size: Int): Array<Cartmodel?> {
            return arrayOfNulls(size)
        }
    }
}