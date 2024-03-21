package com.example.myapplication

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Consultas : AppCompatActivity() {

    lateinit var bConsultar: Button
    lateinit var rgC: RadioGroup
    lateinit var rb1: RadioButton
    lateinit var rb2: RadioButton
    lateinit var rb3: RadioButton
    lateinit var rb4: RadioButton
    lateinit var infoProductos: TextView
    lateinit var valorCons: TextView

    private var listaProductos = mutableListOf<Producto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultas)

        bConsultar = findViewById(R.id.BotonConsultar)
        rgC = findViewById(R.id.rgConsultas)
        rb1 = findViewById(R.id.rbConsultas1)
        rb2 = findViewById(R.id.rbConsultas2)
        rb3 = findViewById(R.id.rbConsultas3)
        rb4 = findViewById(R.id.rbConsultas4)
        infoProductos = findViewById(R.id.displayProductos)
        valorCons = findViewById(R.id.valorConsulta)
        infoProductos.setMovementMethod(ScrollingMovementMethod())
        bConsultar.setOnClickListener{


            // validar que se cumpla con los requisitos antes de consultar
            if (rgC.checkedRadioButtonId == -1 || valorCons.text == "") {

                infoProductos.text = "ERROR: Escoja un tipo de consulta e ingrese el valor antes de generar su consulta."
            } else {
                infoProductos.text = ""

                val valor = valorCons.text.toString().toInt()


                if (rb1.isChecked) {
                    listaProductos = Inventario.consultarProductosPorPrecio(valor).toMutableList()
                } else if (rb2.isChecked) {
                    listaProductos = Inventario.consultarProductosPorCantidad(valor).toMutableList()
                }else if (rb3.isChecked) {
                    listaProductos = Inventario.consultarProductosPorCantidadVendidos(valor).toMutableList()
                } else {
                    listaProductos = Inventario.consultarProductoPorFerreteria(valor).toMutableList()
                }

                var info = ""

                for (p in listaProductos) {
                    info += "ID: ${p.id}\n" +
                            "Nombre: ${p.nombre}\n" +
                            "Cantidad: ${p.cantidad}\n" +
                            "Precio Costo: ${p.precioCosto}\n" +
                            "Precio Venta: ${p.precioVenta}\n" +
                            "Cantidad Vendidos: ${p.cantidadVendidos}\n"
                }
                infoProductos.text = info

            }
        }
    }

    private fun displayInfo(list: MutableList<Producto>)  {

        var info = ""

        for (p in list) {
            info += "ID: ${p.id}\n" +
                    "Nombre: ${p.nombre}\n" +
                    "Cantidad: ${p.cantidad}\n" +
                    "Precio Costo: ${p.precioCosto}\n" +
                    "Precio Venta: ${p.precioVenta}\n" +
                    "Cantidad Vendidos: ${p.cantidadVendidos}\n"
        }
        infoProductos.text = info

    }

}

