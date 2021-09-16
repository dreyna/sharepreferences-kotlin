package com.example.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
        enviarBtn1.setOnClickListener{
            val nombre = nombreEdt.text.toString().trim()
            val estado = swtch01.isChecked
            val edit = sharedPreferences.edit()
            edit.putString("NAME", nombre)
            edit.putBoolean("ESTADO", estado)
            edit.apply()

        }
        enviarBtn2.setOnClickListener{
            val nombre = sharedPreferences.getString("NAME","")
            val estado = sharedPreferences.getBoolean("ESTADO",false)
            mensajeTV.text = "Nombre: $nombre \nEstado: $estado"
        }

    }
}