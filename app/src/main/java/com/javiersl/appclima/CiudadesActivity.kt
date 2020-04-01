package com.javiersl.appclima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class CiudadesActivity : AppCompatActivity() {

    //Crea valores de manera estática
    companion object {val TAG = "CIUDAD"}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val mexicoButton = findViewById<Button>(R.id.btMexico)
        val berlinButton = findViewById<Button>(R.id.btBerlin)

        var ciudad: String? = null

        mexicoButton.setOnClickListener(View.OnClickListener {

            //Crea una ciudad
            //ciudad = Ciudad("Ciudad de México", "Soleado", 28)
            ciudad = "Mexico City"

            //Crea el intent y manda a la pantalla
            val intent = Intent(this, InfoActivity::class.java)
            intent.putExtra(TAG, ciudad)
            startActivity(intent)
        })

        berlinButton.setOnClickListener(View.OnClickListener {

            //Crea una ciudad
            ciudad = "Berlin"

            //Crea el intent y manda a la pantalla
            val intent = Intent(this, InfoActivity::class.java)
            intent.putExtra(TAG, ciudad)
            startActivity(intent)
        })
    }
}
