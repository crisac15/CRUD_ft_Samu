package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class modificar : AppCompatActivity() {
    lateinit var llamarModificar: Button
    lateinit var infoProductoTextView : TextView
    lateinit var productoDespues : TextView
    lateinit var idIngresado : TextInputEditText
    lateinit var nuevaCantidad : TextInputEditText
    lateinit var nuevaVenta : TextInputEditText
    lateinit var nuevoCosto : TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar)



        infoProductoTextView = findViewById(R.id.textAntes)
        productoDespues = findViewById(R.id.textDespues)
        llamarModificar = findViewById(R.id.modifButton)
        idIngresado = findViewById(R.id.idTxtField)
        nuevaCantidad = findViewById(R.id.txtNuevaCantidad)
        nuevaVenta = findViewById(R.id.txtNuevoPrecioVenta)
        nuevoCosto = findViewById(R.id.txtNuevoPrecioCosto)

        llamarModificar.setOnClickListener {

            val productoSeleccionado = Inventario.consultarProductoPorId(idIngresado.text.toString().toInt())

            if (productoSeleccionado != null) {
                val infoProductoAntes = "ID: ${productoSeleccionado.id}\n" +
                        "Nombre: ${productoSeleccionado.nombre}\n" +
                        "Cantidad: ${productoSeleccionado.cantidad}\n" +
                        "Precio Costo: ${productoSeleccionado.precioCosto}\n" +
                        "Precio Venta: ${productoSeleccionado.precioVenta}\n" +
                        "Cantidad Vendidos: ${productoSeleccionado.cantidadVendidos}"

                infoProductoTextView.text = infoProductoAntes

                productoSeleccionado.cantidad = nuevaCantidad.text.toString().toInt()
                productoSeleccionado.precioVenta = nuevaVenta.text.toString().toInt()
                productoSeleccionado.precioCosto = nuevoCosto.text.toString().toInt()
                val infoProductoDesp = "ID: ${productoSeleccionado.id}\n" +
                        "Nombre: ${productoSeleccionado.nombre}\n" +
                        "Cantidad: ${productoSeleccionado.cantidad}\n" +
                        "Precio Costo: ${productoSeleccionado.precioCosto}\n" +
                        "Precio Venta: ${productoSeleccionado.precioVenta}\n" +
                        "Cantidad Vendidos: ${productoSeleccionado.cantidadVendidos}"

                productoDespues.text = infoProductoDesp
            } else {
                infoProductoTextView.text = "No se ha seleccionado ningún producto."
                productoDespues.text = "  "
            }
        }
    }
}
