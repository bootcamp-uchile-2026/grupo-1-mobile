package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.bootcamp.stylenow.ui.components.ItemAyuda

@Composable
fun AyudaScreen(
    onNavigateToDevoluciones: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HorizontalDivider()

        ItemAyuda(
            titulo = "Cambios y devoluciones",
            onItemClick = onNavigateToDevoluciones
        )

        HorizontalDivider()

        ItemAyuda(
            titulo = "Envíos",
            onItemClick = {}
        )

        HorizontalDivider()

        ItemAyuda(
            titulo = "Preguntas Frecuentes",
            onItemClick = {}
        )

        HorizontalDivider()

        ItemAyuda(
            titulo = "Contacto",
            onItemClick = {}
        )

        HorizontalDivider()
    }
}