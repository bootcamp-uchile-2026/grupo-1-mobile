package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cl.bootcamp.stylenow.ui.components.ItemAyuda

@Composable
fun AyudaScreen(
    onNavigateToDevoluciones: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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