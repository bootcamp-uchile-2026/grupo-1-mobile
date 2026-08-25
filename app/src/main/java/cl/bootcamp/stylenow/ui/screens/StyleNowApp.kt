package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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
                SecondaryRoutes.CARRITO -> "Mi Carrito"
                SecondaryRoutes.NOTIFICACIONES -> "Notificaciones"
                SecondaryRoutes.FAVORITOS -> "Favoritos"
                SecondaryRoutes.COMUNIDAD -> "Comunidad"
                SecondaryRoutes.FICHA_PRODUCTO, SecondaryRoutes.CATALOGO, ScreenRoutes.HOME.route  -> ""
                SecondaryRoutes.CAMBIOS_Y_DEVOLUCIONES -> "Cambios y Devoluciones"
                else -> pantallaActual.title
            }

            AppTopBar(
                titulo = titulo,
                notificacionesSelected = rutaActual == SecondaryRoutes.NOTIFICACIONES,
                favoritosSelected = rutaActual == SecondaryRoutes.FAVORITOS,
                carritoSelected = rutaActual == SecondaryRoutes.CARRITO,
                onNavigateBack = { navController.navigateUp() },
                onNavigateToCarrito = {
                    navController.navigate(SecondaryRoutes.CARRITO) {
                        popUpTo(ScreenRoutes.HOME.route) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                onNavigateToFavoritos = {
                    navController.navigate(SecondaryRoutes.FAVORITOS) {
                        popUpTo(ScreenRoutes.HOME.route) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                onNavigateToNotificaciones = {
                    navController.navigate(SecondaryRoutes.NOTIFICACIONES) {
                        popUpTo(ScreenRoutes.HOME.route) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                mostrarBotonAtras = !esPantallaPrincipal,
                mostrarActionIcons = rutaActual != SecondaryRoutes.CARRITO
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
                composable(SecondaryRoutes.NOTIFICACIONES) {
                    NotificacionesScreen()
                }

                composable(SecondaryRoutes.FAVORITOS) {
                    FavoritosScreen()
                }

                composable(SecondaryRoutes.CARRITO) {
                    CarritoScreen()
                }

                composable(SecondaryRoutes.CATALOGO) {
                    CatalogoScreen()
                }

                composable(SecondaryRoutes.FICHA_PRODUCTO) {
                    FichaProductoScreen()
                }

                composable(SecondaryRoutes.CAMBIOS_Y_DEVOLUCIONES) {
                    CambiosYDevolucionesScreen()
                }

                composable(SecondaryRoutes.COMUNIDAD) {
                    ComunidadScreen()
                }
            }
        }
    }
}