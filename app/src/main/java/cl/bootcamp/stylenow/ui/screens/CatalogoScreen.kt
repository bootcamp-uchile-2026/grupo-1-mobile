package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.bootcamp.stylenow.data.DefaultData
import cl.bootcamp.stylenow.ui.components.ItemCatalogo
import cl.bootcamp.stylenow.ui.components.RutaFiltrosElegidos
import cl.bootcamp.stylenow.ui.components.SeccionBotonesCatalogo
import cl.bootcamp.stylenow.ui.components.SeccionTituloCatalogo

@Composable
fun CatalogoScreen(
    onNavigateToFichaProducto: (String) -> Unit
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
    ) {

        item {

            RutaFiltrosElegidos() //Datos simulados hardcodeados
        }

        item {

            SeccionTituloCatalogo(
                titulo = "Vestidos",
                subtitulo = "Encuentra el vestido perfecto para cada ocasión"
            )
        }

        item {

            SeccionBotonesCatalogo(
                textoBoton1 = "Filtros",
                textoBoton2 = "Ordenar"
            )
        }

        items(DefaultData.listaProductos) { producto ->

            ItemCatalogo(
                producto = producto,
                onNavigateToFichaProducto = onNavigateToFichaProducto
            )
        }
    }
}