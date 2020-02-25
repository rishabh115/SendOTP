package com.example.sendotp.data.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Model class for contact. Made it parcelable so that it can be easily passed between
 * components.
 */
data class Contact(val id:Int, val first: String, val last: String, val email: String,
                   val phone: String) : Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:""
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(first)
        parcel.writeString(last)
        parcel.writeString(email)
        parcel.writeString(phone)
    }

    companion object CREATOR : Parcelable.Creator<Contact> {
        override fun createFromParcel(parcel: Parcel): Contact {
            return Contact(parcel)
        }

        override fun newArray(size: Int): Array<Contact?> {
            return arrayOfNulls(size)
        }
    }

    fun getName(): String{
        return "${first} ${last}"
    }
}