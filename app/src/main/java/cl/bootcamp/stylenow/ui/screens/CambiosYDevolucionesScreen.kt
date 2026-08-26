package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cl.bootcamp.stylenow.R
import cl.bootcamp.stylenow.ui.components.ItemFacilidadHome

@Composable
fun CambiosYDevolucionesScreen() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 16.dp)
    ){

        Text(
            text = "Cambios y devoluciones",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.banner_cambios_devoluciones),
            contentDescription = "Banner de la nueva colección",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            ItemFacilidadHome(
                icono = Icons.Filled.CalendarMonth,
                descripcionIcono = "Satisfacción",
                titulo = "Tienes 30 días",
                subTitulo = "Cambia tu producto fácilmente si no es tu talla o simplemente no te gustó"
            )

            ItemFacilidadHome(
                icono = Icons.Filled.Check,
                descripcionIcono = "Calidad",
                titulo = "Garantía de 6 meses",
                subTitulo = "Cobertura legal total ante cualquier falla de fábrica en tus prendas"
            )

            ItemFacilidadHome(
                icono = Icons.Filled.LocalShipping,
                descripcionIcono = "Logística",
                titulo = "Proceso fácil",
                subTitulo = "Devuélvelo gratis en sucursales o coordina el retiro desde tu domicilio"
            )
        }
    }
}