package cl.bootcamp.stylenow.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChangeCircle
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FacilidadesAppHome() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column {

            ItemFacilidadHome(
                icono = Icons.Filled.LocalShipping,
                descripcionIcono = "Icono de entrega a domicilio",
                titulo = "Envíos a todo Chile",
                subTitulo = "Envíos rápidos y seguros"
            )

            Spacer(modifier = Modifier.height(24.dp))

            ItemFacilidadHome(
                icono = Icons.Filled.ChangeCircle,
                descripcionIcono = "Icono de cambios fáciles",
                titulo = "Cambios fáciles",
                subTitulo = "hasta 30 días"
            )

            Spacer(modifier = Modifier.height(24.dp))

            ItemFacilidadHome(
                icono = Icons.Filled.CreditCard,
                descripcionIcono = "Icono de paga como prefieras",
                titulo = "Paga como prefieras",
                subTitulo = "Tarjetas, transferencias y más"
            )
        }
    }
}