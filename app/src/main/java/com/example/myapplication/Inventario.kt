package com.example.myapplication

object Inventario {
    private val productos = mutableListOf<Producto>()


    // Método para agregar un nuevo producto
    fun agregarProducto(producto: Producto) {
        if (productos.any { it.id == producto.id }) {
            println("El producto con ID ${producto.id} ya existe en el inventario.")
        } else {
            productos.add(producto)
        }
    }

    // Método para consultar un producto por su ID
    fun consultarProductoPorId(id: Int): Producto? {
        return productos.find { it.id == id }
    }
    fun consultarProductosPorPrecio(pPrecio: Int): List<Producto> {
        return productos.filter { it.precioVenta == pPrecio}
    }

    // Método para eliminar un producto por su ID
    fun eliminarProducto(id: Int) {
        productos.removeAll { it.id == id }
    }

    // Método para consultar productos por cantidad
    fun consultarProductosPorCantidad(pCantidad: Int): List<Producto> {

        val productosCoincidentes = mutableListOf<Producto>()

        for (pr in productos) {
            if (pr.cantidad == pCantidad) {
                productosCoincidentes.add(pr)
            }
        }
        return productosCoincidentes
    }


    // Método para consultar productos por cantidad de vendidos
    fun consultarProductoPorFerreteria(pIdFerre: Int): List<Producto> {

        val productosCoincidentes = mutableListOf<Producto>()

        for (pr in productos) {
            if (pr.idFerreteria == pIdFerre) {
                productosCoincidentes.add(pr)
            }
        }
        return productosCoincidentes
    }

    // Método para consultar productos por cantidad de vendidos
    fun consultarProductosPorCantidadVendidos(pCantidadVendidos: Int): List<Producto> {

        val productosCoincidentes = mutableListOf<Producto>()

        for (pr in productos) {
            if (pr.cantidadVendidos == pCantidadVendidos) {
                productosCoincidentes.add(pr)
            }
        }
        return productosCoincidentes
    }
}