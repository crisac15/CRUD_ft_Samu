package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputEditText

class agregar : AppCompatActivity() {

    lateinit var addId : TextInputEditText
    lateinit var addNombre : TextInputEditText
    lateinit var addCantidad : TextInputEditText
    lateinit var addVenta : TextInputEditText
    lateinit var addCosto : TextInputEditText
    lateinit var addTotalVendidos : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)

        addId = findViewById(R.id.idAdd)
        addNombre = findViewById(R.id.nameAdd)
        addCantidad = findViewById(R.id.mountAdd)
        addVenta = findViewById(R.id.saleAdd)
        addCosto = findViewById(R.id.costAdd)
        addTotalVendidos = findViewById(R.id.soldAdd)
    }
}