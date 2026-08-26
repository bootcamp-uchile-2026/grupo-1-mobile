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

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                Text(
                    text = "Mujer",
                    style = MaterialTheme.typography.labelLarge
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = "Divisor categoría"
                )

                Text(
                    text = "Vestidos",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }

        item {

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            ) {
                Text(
                    text = "Vestidos",
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = "Encuentra el vestido perfecto para cada ocasión",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        item {

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            ) {

                Button(
                    modifier = Modifier.weight(0.4f),
                    onClick = {}
                ) {
                    Text(
                        text = "Filtros",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(modifier = Modifier.weight(0.2f))

                Button(
                    modifier = Modifier.weight(0.4f),
                    onClick = {}
                ) {
                    Text(
                        text = "Ordenar",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        items(DefaultData.listaProductos) { producto ->

            ItemCatalogo(
                producto = producto,
                onNavigateToFichaProducto = onNavigateToFichaProducto
            )
        }
    }
}