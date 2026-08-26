package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import cl.bootcamp.stylenow.R
import cl.bootcamp.stylenow.data.DefaultData
import cl.bootcamp.stylenow.ui.components.ItemEstrellasValoracion

@Composable
fun ComunidadScreen() {

    //TODO: Pantallas Ayuda ni Cambios y Devoluciones son scrolleables

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 16.dp)
    ) {

        item {

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Inspiración de la comunidad",
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = "Usa #StyleNow en tus redes para aparecer aquí",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        item {

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.categoria_hombre),
                    contentDescription = "Banner Look del mes",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(2f)
                )

                Text(
                    text = "Look del mes",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }

        item {

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

        item {
            Image(
                painter = painterResource(id = R.drawable.banner_descuento_comunidad),
                contentDescription = "Banner Look del mes",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f)
                    .padding(vertical = 16.dp)
            )
        }
    }
}