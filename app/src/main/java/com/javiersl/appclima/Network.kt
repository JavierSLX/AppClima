package com.javiersl.appclima

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity

class Network()
{
    //Elementos estáticos de la clase
    companion object{
        fun hayRed(activity: AppCompatActivity): Boolean
        {
            //Permite obtener el servicio de conectividad de internet y la parsea a ConnectivityManager
            val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo

            //Checa si hay informacion en la red y si está conectada
            return networkInfo != null && networkInfo.isConnected
        }
    }
}