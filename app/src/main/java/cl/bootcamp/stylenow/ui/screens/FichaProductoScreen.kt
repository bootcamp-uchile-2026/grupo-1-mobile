package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Square
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Square
import androidx.compose.material.icons.sharp.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import cl.bootcamp.stylenow.data.DefaultData
import cl.bootcamp.stylenow.ui.components.DatosEstaticosFichaProducto
import cl.bootcamp.stylenow.ui.components.ItemDesplegableFichaProducto
import cl.bootcamp.stylenow.ui.components.SeccionBotonesFichaProducto
import cl.bootcamp.stylenow.ui.components.SelectoresFichaProducto
import cl.bootcamp.stylenow.viewmodel.MainViewModel

@Composable
fun FichaProductoScreen(
    viewModel: MainViewModel = viewModel()
) {

    val productoState by viewModel.selectedProduct.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //Imagen/Carrusel de imágenes(Por ahora una sola imagen)
        item {
            Image(
                painter = painterResource(productoState?.idImagenLocal ?: 1),
                contentDescription = productoState?.nombre,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
                    .aspectRatio(1f)
            )
        }

        //Datos estáticos
        item {

            DatosEstaticosFichaProducto(
                etiqueta = "Nuevo",
                nombre = productoState?.nombre ?: "Nombre Producto",
                precio = productoState?.precio ?: 0.0
            )
        }

        //Selectores
        item {

            var colorSeleccionado by remember { mutableStateOf(DefaultData.listaColores.firstOrNull()) }
            var tallaSeleccionada by remember { mutableStateOf(DefaultData.listaTallas.firstOrNull()) }

            SelectoresFichaProducto(
                colorSeleccionado = colorSeleccionado,
                tallaSeleccionada = tallaSeleccionada,
                onSeleccionarColorClick = { color ->
                    colorSeleccionado = color
                },
                onSeleccionarTallaClick = { talla ->
                    tallaSeleccionada = talla
                },
            )
        }

        //Botones
        item {

            SeccionBotonesFichaProducto()
        }

        //Descripcion
        item {

            ItemDesplegableFichaProducto(titulo = "Descripción")
        }

        //Envíos y cambios
        item {

            ItemDesplegableFichaProducto(titulo = "Envíos y cambios")
        }

        //Pago seguro
        item {

            ItemDesplegableFichaProducto(titulo = "Pago seguro")
        }
    }
}