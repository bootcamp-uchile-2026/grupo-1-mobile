package cl.bootcamp.stylenow.data

import java.util.UUID

data class Producto(
    val id: String = UUID.randomUUID().toString(),
    val nombre: String,
    val descripcion: String,
    val precio: Double
    //val categoria: Categoria // ver también con el tema de subcategorías
)
