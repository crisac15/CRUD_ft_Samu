package com.example.myapplication

class Inventario {
    private val productos = mutableListOf<Producto>()

    // Método para agregar un nuevo producto
    fun agregarProducto(producto: Producto) {
        if (productos.any { it.id == producto.id }) {
            println("El producto con ID ${producto.id} ya existe en el inventario.")
        } else {
            productos.add(producto)
        }
    }

    // Método para aumentar la cantidad de un producto existente por su ID
    fun aumentarCantidadProducto(id: Int, cantidad: Int) {
        val producto = productos.find { it.id == id }
        if (producto != null) {
            producto.cantidad += cantidad
        } else {
            println("El producto con ID $id no existe.")
        }
    }

    // Método para consultar un producto por su ID
    fun consultarProductoPorId(id: Int): Producto? {
        return productos.find { it.id == id }
    }

    // Método para modificar la información de un producto
    fun modificarProducto(id: Int, nuevoPrecioCosto: Double, nuevoPrecioVenta: Double, nuevaCantidad: Int) {
        val producto = productos.find { it.id == id }
        if (producto != null) {
            producto.precioCosto = nuevoPrecioCosto
            producto.precioVenta = nuevoPrecioVenta
            producto.cantidad = nuevaCantidad
        }
    }

    // Método para eliminar un producto por su ID
    fun eliminarProducto(id: Int) {
        productos.removeAll { it.id == id }
    }
}