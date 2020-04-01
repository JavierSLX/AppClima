package com.javiersl.appclima

import android.os.Parcel
import android.os.Parcelable

//Implementa Parcelable para poder usar el intent con el objeto y pasar información
class Ciudad(): Parcelable
{
    var nombre: String? = null
    var estado: String? = null
    var temperatura: Int? = null

    constructor(parcel: Parcel) : this() {
        nombre = parcel.readString()
        estado = parcel.readString()
        temperatura = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    constructor(nombre: String, estado: String, temperatura: Int):this()
    {
        this.nombre = nombre
        this.estado = estado
        this.temperatura = temperatura
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(estado)
        parcel.writeValue(temperatura)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Ciudad> {
        override fun createFromParcel(parcel: Parcel): Ciudad {
            return Ciudad(parcel)
        }

        override fun newArray(size: Int): Array<Ciudad?> {
            return arrayOfNulls(size)
        }
    }
}