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

@Composable
fun CatalogoScreen(
    onNavigateToFichaProducto: (String) -> Unit
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
    ) {

        item {


        }

        items(DefaultData.listaProductos) { producto ->

            ItemCatalogo(
                producto = producto,
                onNavigateToFichaProducto = onNavigateToFichaProducto
            )
        }
    }
}