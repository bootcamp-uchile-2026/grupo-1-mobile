package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.bootcamp.stylenow.data.DefaultData
import cl.bootcamp.stylenow.ui.components.ItemCatalogo
import cl.bootcamp.stylenow.ui.components.RutaFiltrosElegidos
import cl.bootcamp.stylenow.ui.components.SeccionBotonesCatalogo
import cl.bootcamp.stylenow.ui.components.SeccionTituloCatalogo
import cl.bootcamp.stylenow.ui.components.SeccionTituloComunidad

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