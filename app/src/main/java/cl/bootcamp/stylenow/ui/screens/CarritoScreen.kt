package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.bootcamp.stylenow.data.DefaultData
import cl.bootcamp.stylenow.ui.components.ItemProductoCarrito

@Composable
fun CarritoScreen(
    onNavigateToFichaProducto: (String) -> Unit
) {

    //Variable para demostración HITO 1. Luego eliminar para manejar esto en el viewmodel
    val listaMutableProductos = remember {
        DefaultData.listaProductos.toMutableStateList()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 16.dp)
    ){

        LazyColumn(
            modifier = Modifier
                .weight(1f)
        ) {

            items(listaMutableProductos) { producto ->

                ItemProductoCarrito(
                    producto = producto,
                    onNavigateToFichaProducto = onNavigateToFichaProducto,
                    onDeleteClick = {
                        listaMutableProductos.remove(producto)
                    }
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Total: $${listaMutableProductos.sumOf { it.precio }.toInt()}",
                style = MaterialTheme.typography.bodyLarge
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {

                }
            ) {
                Text(
                    text = "Continuar compra",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}