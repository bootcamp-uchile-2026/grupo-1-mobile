package cl.bootcamp.stylenow.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cl.bootcamp.stylenow.data.Producto

@Composable
fun ItemCatalogo(
    producto: Producto,
    onNavigateToFichaProducto: (String) -> Unit
) {

    Card(
        modifier = Modifier.padding(vertical = 8.dp),
        onClick = { onNavigateToFichaProducto(producto.id) }
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()

        ) {

            Image(
                painter = painterResource(producto.idImagenLocal),
                contentDescription = producto.nombre,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(0.4f)
                    .aspectRatio(1f)
            )

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .weight(0.6f)
                    .padding(start = 16.dp)
            ) {

                Text(
                    text = producto.nombre,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "$${producto.precio.toInt()}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}