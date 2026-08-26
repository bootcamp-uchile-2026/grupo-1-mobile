package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.bootcamp.stylenow.data.Categoria
import cl.bootcamp.stylenow.data.Producto
import cl.bootcamp.stylenow.ui.components.BannerPrincipalHome
import cl.bootcamp.stylenow.ui.components.CarruselCategoriasHome
import cl.bootcamp.stylenow.ui.components.FacilidadesAppHome
import cl.bootcamp.stylenow.ui.components.ItemCatalogo
import cl.bootcamp.stylenow.ui.components.SeccionComunidadHome

@Composable
fun HomeScreen(
    productos: List<Producto>,
    categorias: List<Categoria>,
    onNavigateToFichaProducto: (String) -> Unit,
    onNavigateToComunidad: () -> Unit,
    onNavigateToCatalogo: () -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //Seccion banner
        item {

            BannerPrincipalHome(
                titulo = "Tu estilo, tu momento",
                subTitulo = "Descubre lo nuevo en ropa y accesorios para cada ocasión.",
                textoBoton = "COMPRAR AHORA"
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))
        }

        //Seccion facilidades app
        item {

            FacilidadesAppHome()

            HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))
        }

        //Seccion Categorías
        item {
            CarruselCategoriasHome(
                categorias = categorias,
                onNavigateToCatalogo = onNavigateToCatalogo
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))
        }

        //Seccion Comunidad
        item {

            SeccionComunidadHome(
                onNavigateToComunidad = onNavigateToComunidad
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 24.dp))
        }

        //Seccion Catálogo
        items(productos) { producto ->

            ItemCatalogo(
                producto = producto,
                onNavigateToFichaProducto = onNavigateToFichaProducto
            )
        }
    }
}