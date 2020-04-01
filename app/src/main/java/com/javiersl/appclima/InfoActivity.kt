package com.javiersl.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_info.*
import org.json.JSONArray
import org.json.JSONObject

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        //Obtiene el valor del intent de las ciudades
        val ciudad = intent.getStringExtra(CiudadesActivity.TAG)

        val txtCiudad = findViewById<TextView>(R.id.txtCiudad)
        val txtTemperatura = findViewById<TextView>(R.id.txtGrados)
        val txtEstado = findViewById<TextView>(R.id.txtEstado)

        //Valida que haya internet
        if(Network.hayRed(this))
        {
            //Hace la peticion a la api de clima
            val url = "http://api.openweathermap.org/data/2.5/weather?q=${ciudad}&appid=ae7fc223553378dfb85182defbb9513c&units=metric"
            Request.solicitudHttp(this, url, object: Request.Companion.RequestListener{

                override fun response(data: String) {

                    val response = JSONObject(data)
                    val weather = response.getJSONArray("weather")
                    val temperature = response.getJSONObject("main")

                    txtCiudad.setText(ciudad)
                    txtEstado.setText((weather.getJSONObject(0)).getString("description"))
                    txtTemperatura.setText(temperature.getDouble("temp").toString())
                }

                override fun error(error: String) {
                    Log.i("clima", error)
                }
            })
        }
    }
}
