package com.example.vegi.model

import android.os.Parcel
import android.os.Parcelable

data class ItemSubCategory(
    var id:Int,
    var image:Int,
    var title:String,
    var price:String,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(image)
        parcel.writeString(title)
        parcel.writeString(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemSubCategory> {
        override fun createFromParcel(parcel: Parcel): ItemSubCategory {
            return ItemSubCategory(parcel)
        }

        override fun newArray(size: Int): Array<ItemSubCategory?> {
            return arrayOfNulls(size)
        }
    }
}
