package cl.bootcamp.stylenow.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DatosEstaticosFichaProducto(
    etiqueta: String,
    nombre: String,
    precio: Double
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = etiqueta,//Etiqueta que solo sale si es nuevo?
            style = MaterialTheme.typography.labelMedium
        )

        Text(
            text = nombre,
            style = MaterialTheme.typography.titleLarge,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )

        Text(
            text = "$${precio.toInt()}",
            style = MaterialTheme.typography.titleMedium,
            fontSize = 20.sp
        )


        //Fila de estrellas de valoración
        ItemEstrellasValoracion()
    }
}