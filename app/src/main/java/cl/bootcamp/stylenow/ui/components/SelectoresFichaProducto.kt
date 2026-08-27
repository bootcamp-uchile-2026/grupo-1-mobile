package cl.bootcamp.stylenow.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Square
import androidx.compose.material.icons.outlined.Square
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import cl.bootcamp.stylenow.data.DefaultData

@Composable
fun SelectoresFichaProducto(
    colorSeleccionado: Color?,
    tallaSeleccionada: String?,
    onSeleccionarColorClick: (Color) -> Unit,
    onSeleccionarTallaClick: (String?) -> Unit
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
    ) {
        Text(
            text = "Color: Beige",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        //Fila de opciones de colores
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(vertical = 8.dp)
                .selectableGroup()
        )
        {

            DefaultData.listaColores.forEach { color ->

                val estaSeleccionado = color == colorSeleccionado

                Icon(
                    imageVector = if(estaSeleccionado) Icons.Filled.Square else Icons.Outlined.Square,
                    contentDescription = color.toString(),
                    tint = color,
                    modifier = Modifier
                        .selectable(
                            selected = estaSeleccionado,
                            onClick = { onSeleccionarColorClick(color) },
                            role = Role.RadioButton
                        )
                )
            }
        }

        Text(
            text = "Talla: M",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        //Fila de opciones de colores
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .selectableGroup()
        )
        {
            DefaultData.listaTallas.forEach { talla ->

                val estaSeleccionado = talla == tallaSeleccionada

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .background(
                            color = if (estaSeleccionado) MaterialTheme.colorScheme.primaryContainer else Color.LightGray
                        )
                        .selectable(
                            selected = estaSeleccionado,
                            onClick = { onSeleccionarTallaClick(talla) },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = talla,
                        color = if (estaSeleccionado) MaterialTheme.colorScheme.onPrimaryContainer else Color.Black,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        Text(
            text = "Guía de Tallas",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.secondaryContainer)
                .padding(vertical = 4.dp, horizontal = 8.dp)
        )
    }
}