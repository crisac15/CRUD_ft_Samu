package com.example.myapplication

data class Producto(
    val id: Int,
    val nombre: String,
    var cantidad: Int,
    var precioCosto: Double,
    var precioVenta: Double,
    var cantidadVendidos: Int
)