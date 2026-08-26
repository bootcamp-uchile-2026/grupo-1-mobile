package cl.bootcamp.stylenow.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cl.bootcamp.stylenow.data.DefaultData

@Composable
fun CarruselResenasComunidad() {

    Text(
        text = "Reseñas de usuarios",
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(vertical = 16.dp)
    )

    //Carrusel looks de la comunidad
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {

        items(DefaultData.listaProductos) { producto ->

            Card(
                modifier = Modifier.fillParentMaxWidth(0.75f)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {

                    Image(
                        painter = painterResource(producto.idImagenLocal),
                        contentDescription = producto.nombre,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(4f / 3f)
                    )

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, bottom = 16.dp)
                    ) {

                        ItemEstrellasValoracion()

                        Text(
                            text = "Nombre usuario",
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Descripción de reseña",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
    }
}