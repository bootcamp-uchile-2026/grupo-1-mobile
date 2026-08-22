package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.stylenow.ui.components.AppBottomBar
import cl.bootcamp.stylenow.ui.components.AppTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StyleNowApp(

) {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val rutaActual = navBackStackEntry?.destination?.route ?: ScreenRoutes.HOME.route
    val pantallaActual = ScreenRoutes.entries.find { it.route == rutaActual } ?: ScreenRoutes.HOME

    val esPantallaPrincipal = ScreenRoutes.entries.any { it.route == rutaActual }

    Scaffold(

        topBar = {

            val titulo = when(rutaActual){
                "carrito" -> "Mi Carrito"
                "ficha_producto", "catalogo", ScreenRoutes.HOME.route  -> ""
                else -> pantallaActual.title
            }

            AppTopBar(
                titulo = titulo,
                onNavigateBack = { navController.navigateUp() },
                onNavigateToCarrito = { navController.navigate("carrito") },
                mostrarBotonAtras = !esPantallaPrincipal,
                mostrarCarrito = rutaActual != "carrito"
            )
        },
        bottomBar = {

            if(esPantallaPrincipal) {
                AppBottomBar(
                    rutaActual = rutaActual,
                    onNavigateTo = { ruta ->

                        navController.navigate(ruta) {
                            popUpTo(ScreenRoutes.HOME.route) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        },
        snackbarHost = { /*TODO*/ },
        modifier = Modifier.fillMaxSize()

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
        ) {

            NavHost(
                navController = navController,
                startDestination = ScreenRoutes.HOME.route
            ) {
                //Pantallas en Navegacion Inferior
                composable(ScreenRoutes.HOME.route) {
                    HomeScreen()
                }

                composable(ScreenRoutes.CATEGORIAS.route) {
                    CategoriasScreen()
                }

                composable(ScreenRoutes.MI_CUENTA.route) {
                    MiCuentaScreen()
                }

                composable(ScreenRoutes.AYUDA.route) {
                    AyudaScreen()
                }

                //Pantallas secundarias
                composable("carrito") {
                    CarritoScreen()
                }

                composable("catalogo") {
                    CatalogoScreen()
                }

                composable("ficha_producto") {
                    FichaProductoScreen()
                }
            }
        }
    }
}