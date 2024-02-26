package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.databinding.ActivityAgregarBinding
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class agregar : AppCompatActivity() {
    lateinit var addResul: TextView
    lateinit var llamarAgregar: Button
    lateinit var addId : TextInputEditText
    lateinit var addNombre : TextInputEditText
    lateinit var addCantidad : TextInputEditText
    lateinit var addVenta : TextInputEditText
    lateinit var addCosto : TextInputEditText
    lateinit var addTotalVendidos : TextInputEditText

    private lateinit var  binding: ActivityAgregarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)

        llamarAgregar = findViewById(R.id.addButton)

        addResul = findViewById(R.id.textAddRes)
        addId = findViewById(R.id.idAdd)
        addNombre = findViewById(R.id.nameAdd)
        addCantidad = findViewById(R.id.mountAdd)
        addVenta = findViewById(R.id.saleAdd)
        addCosto = findViewById(R.id.costAdd)
        addTotalVendidos = findViewById(R.id.soldAdd)



        llamarAgregar.setOnClickListener {
            if (Inventario.consultarProductoPorId(addId.text.toString().toInt()) == null) {

                Inventario.agregarProducto(Producto(addId.text.toString().toInt(), addNombre.text.toString(), addCantidad.text.toString().toInt(), addCosto.text.toString().toInt(), addVenta.text.toString().toInt(), addTotalVendidos.text.toString().toInt()))

                val productoAgregar = Inventario.consultarProductoPorId(addId.text.toString().toInt())
                if (productoAgregar != null) {
                    val infoProductoAgregado = "ID: ${productoAgregar.id}\n" +
                            "Nombre: ${productoAgregar.nombre}\n" +
                            "Cantidad: ${productoAgregar.cantidad}\n" +
                            "Precio Costo: ${productoAgregar.precioCosto}\n" +
                            "Precio Venta: ${productoAgregar.precioVenta}\n" +
                            "Cantidad Vendidos: ${productoAgregar.cantidadVendidos}"

                    addResul.text = infoProductoAgregado
                } else {
                    addResul.text = "ERROR: No se pudo agregar el producto."
                }
            } else {
                addResul.text = "ERROR: Ya existe un producto con ese ID"
            }

        }
    }
}