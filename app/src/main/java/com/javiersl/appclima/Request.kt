package com.javiersl.appclima

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.lang.Exception

class Request {

    companion object{

        interface RequestListener{
            fun response(data: String)
            fun error(error: String)
        }

        //Metodo para Volley
        fun solicitudHttp(context: Context, url: String, callback: RequestListener)
        {
            val queue = Volley.newRequestQueue(context)

            //Arma la solicitud
            val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String>{

                //Arma la respuesta
                response ->
                try {
                    callback.response(response)
                }catch (e: Exception){
                    callback.error(e.toString())
                }
            }, Response.ErrorListener{
                callback.error("Error")
            })

            //Agrega la solicitud a la cola
            queue.add(solicitud)
        }
    }
}