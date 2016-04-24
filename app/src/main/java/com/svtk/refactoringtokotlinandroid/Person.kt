package com.svtk.refactoringtokotlinandroid

import android.os.Parcel
import android.os.Parcelable

class Person(name: String) : Parcelable {
    var id: Int = 0
    var name: String = name
    var email: String? = null
    var phoneNumber: String? = null

    private constructor(source: Parcel): this(source.readString()) {
        id = source.readInt()
        email = source.readString()
        phoneNumber = source.readString()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeInt(id)
        dest.writeString(email)
        dest.writeString(phoneNumber)
    }

    override fun describeContents(): Int = 0

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<Person> {
            override fun createFromParcel(source: Parcel) = Person(source)

            override fun newArray(size: Int): Array<out Person?> = Array<Person?>(size, { null })
        }
    }
}