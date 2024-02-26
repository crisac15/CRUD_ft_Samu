package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class Delete : AppCompatActivity() {

    lateinit var deleteResul: TextView
    lateinit var llamarBorrar: Button
    lateinit var deleteID: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)


        llamarBorrar = findViewById(R.id.deleteButton)
        deleteResul = findViewById(R.id.deleteRes)
        deleteID = findViewById(R.id.dltField)

        llamarBorrar.setOnClickListener {
            if (Inventario.consultarProductoPorId(deleteID.text.toString().toInt()) != null) {

                val productoBorrar = Inventario.consultarProductoPorId(deleteID.text.toString().toInt())

                if (productoBorrar != null) {
                    val infoProductoBorrado = "Se ha eliminado correctamente el producto:\n" +
                            "ID: ${productoBorrar.id}\n" +
                            "Nombre: ${productoBorrar.nombre}\n" +
                            "Cantidad: ${productoBorrar.cantidad}\n" +
                            "Precio Costo: ${productoBorrar.precioCosto}\n" +
                            "Precio Venta: ${productoBorrar.precioVenta}\n" +
                            "Cantidad Vendidos: ${productoBorrar.cantidadVendidos}"

                    deleteResul.text = infoProductoBorrado

                    Inventario.eliminarProducto(productoBorrar.id)
                }
            } else {
                deleteResul.text = "ERROR: No se puede eliminar un producto que no existe."
            }
        }
    }
}