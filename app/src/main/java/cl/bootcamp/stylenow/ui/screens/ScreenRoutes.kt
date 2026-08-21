package cl.bootcamp.stylenow.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.automirrored.sharp.Help
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.sharp.Category
import androidx.compose.material.icons.sharp.Help
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Looks
import androidx.compose.material.icons.sharp.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class ScreenRoutes(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector
) {

    HOME(
        route = "inicio",
        title = "Inicio",
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home
    ),

    CATEGORIAS(
        route = "categorias",
        title = "Categorías",
        selectedIcon = Icons.Filled.Category,
        unSelectedIcon = Icons.Outlined.Category
    ),

    MI_CUENTA(
        route = "mi_cuenta",
        title = "Mi Cuenta",
        selectedIcon = Icons.Filled.Person,
        unSelectedIcon = Icons.Outlined.Person
    ),

    AYUDA(
        route = "ayuda",
        title = "Ayuda",
        selectedIcon = Icons.AutoMirrored.Filled.Help,
        unSelectedIcon = Icons.AutoMirrored.Outlined.Help
    ),

    //Solo declaración, estará lista para el hito 2
//    LOOKS(
//        route = "looks",
//        title = "Looks",
//        selectedIcon = Icons.Filled.Looks,
//        unSelectedIcon = Icons.Outlined.Looks
//    )


}