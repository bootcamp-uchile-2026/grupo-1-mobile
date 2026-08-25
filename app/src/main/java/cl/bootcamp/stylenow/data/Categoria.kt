package cl.bootcamp.stylenow.data

import cl.bootcamp.stylenow.R
import java.util.UUID

data class Categoria(
    val id: String = UUID.randomUUID().toString(),
    val nombre: String,
    val idImagenLocal: Int? = null
)
