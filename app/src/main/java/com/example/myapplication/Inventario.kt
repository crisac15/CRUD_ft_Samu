package com.example.myapplication

object Inventario {
    private val productos = mutableListOf<Producto>()


    // Método para obtener la lista de productos
    fun obtenerListaProductos(): List<Producto> {
        return productos.toList() // Devuelve una copia de la lista para evitar modificaciones externas
    }
    // Método para agregar un nuevo producto
    fun agregarProducto(producto: Producto) {
        if (productos.any { it.id == producto.id }) {
            println("El producto con ID ${producto.id} ya existe en el inventario.")
        } else {
            productos.add(producto)
        }
    }

    // Método para aumentar la cantidad de un producto existente por su ID  sdas
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
    fun consultarProductosPorPrecio(pPrecio: Int): List<Producto> {
        return productos.filter { it.precioVenta == pPrecio}
    }

    // Método para consultar productos por cantidad
    fun consultarProductosPorCantidad(pCantidad: Int, maxCantidad: Int): List<Producto> {
        return productos.filter { it.cantidad == pCantidad}
    }

    // Método para consultar productos por cantidad de vendidos
    fun consultarProductosPorCantidadVendidos(pCantidadVendidos: Int): List<Producto> {
        return productos.filter { it.cantidadVendidos == pCantidadVendidos }
    }
    // Método para modificar la información de un producto sdfsadfsdfsdf
    fun modificarProducto(id: Int, nuevoPrecioCosto: Int, nuevoPrecioVenta: Int, nuevaCantidad: Int) {
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