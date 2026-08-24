package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChangeCircle
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.bootcamp.stylenow.R
import cl.bootcamp.stylenow.data.Categoria
import cl.bootcamp.stylenow.data.Producto

@Composable
fun HomeScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Intentar modularizar lo máximo posible

        //Seccion banner
        item {

            Column(
            )
            {
                //Imagen banner de nueva colección
                Image(
                    painter = painterResource(id = R.drawable.banner_nueva_coleccion),
                    contentDescription = "Banner de la nueva colección",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )

                Text(
                    text = "Nueva colección",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                        .padding(vertical = 12.dp, horizontal = 16.dp)
                )

                Text(
                    text = "Tu estilo, tu momento",
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 32.sp,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )

                Text(
                    text = "Descubre lo nuevo en ropa y accesorios para cada ocasión.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(vertical = 12.dp, horizontal = 16.dp)
                )

                Button(
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    onClick = {}
                ) {
                    Text(
                        text = "COMPRAR AHORA",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier
                            .padding(vertical = 6.dp, horizontal = 16.dp)
                    )
                }
            }
        }

        //Seccion facilidades app
        item {
            HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {

                Column {

                    //Modularizar a /components
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    )
                    {
                        Icon(
                            imageVector = Icons.Filled.LocalShipping,
                            contentDescription = "Icono de entrega a domicilio"
                        )

                        Spacer(modifier = Modifier.width(24.dp))

                        Column(){
                            Text(
                                text = "Envíos a todo Chile",
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )

                            Text(
                                text = "Envíos rápidos y seguros",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    )
                    {
                        Icon(
                            imageVector = Icons.Filled.ChangeCircle,
                            contentDescription = "Icono de cambios fáciles"
                        )

                        Spacer(modifier = Modifier.width(24.dp))

                        Column(){
                            Text(
                                text = "Cambios fáciles",
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )

                            Text(
                                text = "hasta 30 días",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            imageVector = Icons.Filled.CreditCard,
                            contentDescription = "Icono de paga como prefieras"
                        )

                        Spacer(modifier = Modifier.width(24.dp))

                        Column(){
                            Text(
                                text = "Paga como prefieras",
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )

                            Text(
                                text = "Tarjetas, transferencias y más",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }

        //Seccion Categorías
        item {
            HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))

            Text(
                text = "Categorías populares",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                //Por ahora lista aquí, luego mover a Default Data
                val listaCategorias = listOf(
                    Categoria(
                        nombre = "Mujer",
                        idImagenLocal = R.drawable.categoria_mujer
                    ),

                    Categoria(
                        nombre = "Accesorios",
                        idImagenLocal = R.drawable.categoria_accesorios
                    ),

                    Categoria(
                        nombre = "Hombre",
                        idImagenLocal = R.drawable.categoria_hombre
                    )
                )


                items(listaCategorias) {

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillParentMaxWidth(0.4f)
                    ){
                        Image(
                            painter = painterResource(it.idImagenLocal ?: R.drawable.categoria_accesorios),
                            contentDescription = "Imagen de la categoría ${it.nombre}",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                        )

                        Text(
                            text = it.nombre,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }

        //Seccion Comunidad
        item {

            HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))

            Text(
                text = "Comunidad",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(
                onClick = {}
            ) {
                Text(
                    text = "VER COMUNIDAD",
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                        .padding(vertical = 6.dp, horizontal = 16.dp)
                )
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))
        }

        //Sección Catálogo
        
        val listaProductos = listOf(
            Producto(
                nombre = "Conjunto Hombre",
                descripcion = "Lorem ipsum dolor sit amet consectetur adipiscing elit inceptos litora, aptent cursus aenean fringilla egestas odio magnis.",
                precio = 29990.0,
                idImagenLocal = R.drawable.producto_hombre,
                categoria = Categoria(nombre = "Hombre")
            ),

            Producto(
                nombre = "Conjunto Mujer",
                descripcion = "Lorem ipsum dolor sit amet consectetur adipiscing elit inceptos litora, aptent cursus aenean fringilla egestas odio magnis.",
                precio = 39990.0,
                idImagenLocal = R.drawable.producto_mujer,
                categoria = Categoria(nombre = "Mujer")
            ),

            Producto(
                nombre = "Conjunto Accesorio",
                descripcion = "Lorem ipsum dolor sit amet consectetur adipiscing elit inceptos litora, aptent cursus aenean fringilla egestas odio magnis.",
                precio = 19990.0,
                idImagenLocal = R.drawable.producto_accesorio,
                categoria = Categoria(nombre = "Accesorio")
            )
        )
        
        items(listaProductos) { producto ->

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            ){

                Image(
                    painter = painterResource(producto.idImagenLocal),
                    contentDescription = producto.nombre,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .weight(0.3f)
                        .aspectRatio(1f)
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .weight(0.7f)
                        .padding(start = 16.dp)
                ){

                    Text(
                        text = producto.nombre,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "$${producto.precio.toInt()}",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}