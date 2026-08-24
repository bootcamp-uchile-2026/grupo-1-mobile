package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Square
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Square
import androidx.compose.material.icons.sharp.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.bootcamp.stylenow.R

@Composable
fun FichaProductoScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //Imagen/Carrusel de imágenes
        item {
            Image(
                painter = painterResource(R.drawable.producto_hombre), //Cambiar luego al de viewmodel, para obtener al que se le hizo clic
                contentDescription = "Producto Hombre",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
                    .aspectRatio(1f)
            )
        }

        //Datos estáticos
        item {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "Nuevo",//Etiqueta que solo sale si es nuevo?
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = "Conjunto Hombre", //Cambiar luego al de viewmodel, para obtener al que se le hizo clic
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                )

                Text(
                    text = "$29.990", //Cambiar luego al de viewmodel, para obtener al que se le hizo clic
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 20.sp
                )


                //Fila de estrellas de valoración
                Row(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                )
                {
                    for (i in 1..5) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Estrella de valoración", //Todos deberían tener el mismo con la puntuación total del producto
                            tint = Color.Yellow
                        )
                    }
                }
            }
        }

        //Selectores
        item {
            val listaTallas = listOf("XS", "S", "M", "L", "XL")
            val listaColores = listOf(Color.Black, Color.White, Color.Green, Color.Magenta)
            var colorSeleccionado by remember { mutableStateOf(listaColores.firstOrNull()) }
            var tallaSeleccionada by remember { mutableStateOf(listaTallas.firstOrNull()) }

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

                    listaColores.forEach { color ->

                        val estaSeleccionado = color == colorSeleccionado

                        Icon(
                            imageVector = if(estaSeleccionado) Icons.Filled.Square else Icons.Outlined.Square,
                            contentDescription = color.toString(),
                            tint = color,
                            modifier = Modifier
                                .selectable(
                                    selected = estaSeleccionado,
                                    onClick = { colorSeleccionado = color },
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
                    listaTallas.forEach { talla ->

                        val estaSeleccionado = talla == tallaSeleccionada

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                //.clip(RoundedCornerShape(8.dp))
                                .background(
                                    color = if (estaSeleccionado) MaterialTheme.colorScheme.primaryContainer else Color.LightGray
                                )
                                .selectable(
                                    selected = estaSeleccionado,
                                    onClick = { tallaSeleccionada = talla },
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

        //Botones
        item {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            ){

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = {}
                ) {
                    Text(
                        text = "AGREGAR AL CARRITO",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier
                            .padding(vertical = 6.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = {}
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = "Icono favoritos"
                        )

                        Text(
                            text = "AGREGAR A FAVORITOS",
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier
                                .padding(vertical = 6.dp)
                        )
                    }
                }
            }
        }

        //Descripcion
        item {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 16.dp)
            ){
                Text(
                    text = "Descripción",
                    style = MaterialTheme.typography.titleMedium
                )

                Icon(
                    imageVector = Icons.Sharp.ArrowDropDown,
                    contentDescription = "Icono desplegable para descripción"
                )
            }
        }

        //Envíos y cambios
        item {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 16.dp)
            ){
                Text(
                    text = "Envíos y cambios",
                    style = MaterialTheme.typography.titleMedium
                )

                Icon(
                    imageVector = Icons.Sharp.ArrowDropDown,
                    contentDescription = "Icono desplegable para descripción"
                )
            }
        }

        //Pago seguro
        item {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 16.dp)
            ){
                Text(
                    text = "Envíos y cambios",
                    style = MaterialTheme.typography.titleMedium
                )

                Icon(
                    imageVector = Icons.Sharp.ArrowDropDown,
                    contentDescription = "Icono desplegable para descripción"
                )
            }
        }
    }
}