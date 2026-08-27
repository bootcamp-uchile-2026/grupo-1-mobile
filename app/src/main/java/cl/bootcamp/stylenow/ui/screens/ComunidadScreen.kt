package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.bootcamp.stylenow.R
import cl.bootcamp.stylenow.ui.components.BannerPrincipalComunidad
import cl.bootcamp.stylenow.ui.components.CarruselResenasComunidad
import cl.bootcamp.stylenow.ui.components.ImagenBannerHorizontal
import cl.bootcamp.stylenow.ui.components.SeccionTituloComunidad

@Composable
fun ComunidadScreen() {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 16.dp)
    ) {

        item {

            SeccionTituloComunidad(
                titulo = "Inspiración de la comunidad",
                subtitulo = "Usa #StyleNow en tus redes para aparecer aquí"
            )
        }

        item {

            BannerPrincipalComunidad(
                imagenId = R.drawable.categoria_hombre,
                etiqueta = "Look del mes"
            )
        }

        item {

            CarruselResenasComunidad()
        }

        item {

            Spacer(modifier = Modifier.height(16.dp))

            ImagenBannerHorizontal(
                imagenId = R.drawable.banner_descuento_comunidad,
                descripcion = "Banner Look del mes"
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}