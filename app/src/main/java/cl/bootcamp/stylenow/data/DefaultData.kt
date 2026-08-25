package cl.bootcamp.stylenow.data

import androidx.compose.ui.graphics.Color
import cl.bootcamp.stylenow.R

object DefaultData {

    val listaTallas = listOf("XS", "S", "M", "L", "XL")
    val listaColores = listOf(Color.Blue, Color.White, Color.Green, Color.Magenta)


    val listaCategorias = listOf(
        Categoria(
            id = "1",
            nombre = "Mujer",
            idImagenLocal = R.drawable.categoria_mujer
        ),

        Categoria(
            id = "2",
            nombre = "Accesorios",
            idImagenLocal = R.drawable.categoria_accesorios
        ),

        Categoria(
            id = "3",
            nombre = "Hombre",
            idImagenLocal = R.drawable.categoria_hombre
        )
    )

    val listaProductos = listOf(
        Producto(
            id = "1",
            nombre = "Vestido",
            descripcion = "Vestido ideal para el verano, confeccionado con fibras naturales.",
            precio = 29990.0,
            idImagenLocal = R.drawable.producto_mujer,
            categoria = Categoria(nombre = "Mujer")
        ),
        Producto(
            id = "2",
            nombre = "Camisa",
            descripcion = "Camisa de mezclilla resistente y moderna.",
            precio = 24990.0,
            idImagenLocal = R.drawable.producto_hombre,
            categoria = Categoria(nombre = "Hombre")
        ),
        Producto(
            id = "3",
            nombre = "Conjunto Accesorios",
            descripcion = "Aros y collar dorados.",
            precio = 14990.0,
            idImagenLocal = R.drawable.producto_accesorio,
            categoria = Categoria(nombre = "Accesorios")
        )
    )
}