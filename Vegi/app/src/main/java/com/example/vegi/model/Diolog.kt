package com.example.vegi.model

import android.os.Parcel
import android.os.Parcelable

data class Diolog(
    var id:Int,
    var title:String,
    var address:String,
    var data:String
):
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(address)
        parcel.writeString(data)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Diolog> {
        override fun createFromParcel(parcel: Parcel): Diolog {
            return Diolog(parcel)
        }

        override fun newArray(size: Int): Array<Diolog?> {
            return arrayOfNulls(size)
        }
    }
}