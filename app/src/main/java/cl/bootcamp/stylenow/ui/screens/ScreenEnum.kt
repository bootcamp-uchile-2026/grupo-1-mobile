package cl.bootcamp.stylenow.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

enum class ScreenEnum(
    val titulo: String,
    val icono: ImageVector
) {
    //Aquí se definirán las pantallas
    //Por mientras como ejemplo el home
    HOME(
        titulo = "Home", // o catálogo
        icono = Icons.Filled.Home
    )
}