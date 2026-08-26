package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.stylenow.data.DefaultData
import cl.bootcamp.stylenow.ui.components.AppBottomBar
import cl.bootcamp.stylenow.ui.components.AppTopBar
import cl.bootcamp.stylenow.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StyleNowApp(
    viewModel: MainViewModel = viewModel()
) {

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val rutaActual = navBackStackEntry?.destination?.route ?: ScreenRoutes.HOME.route
    val pantallaActual = ScreenRoutes.entries.find { it.route == rutaActual } ?: ScreenRoutes.HOME

    val esPantallaPrincipal = ScreenRoutes.entries.any { it.route == rutaActual }

    val rutasFlotantes = listOf(
        SecondaryRoutes.NOTIFICACIONES,
        SecondaryRoutes.FAVORITOS,
        SecondaryRoutes.CARRITO,
        SecondaryRoutes.FICHA_PRODUCTO,
        SecondaryRoutes.COMUNIDAD,
        SecondaryRoutes.CATALOGO
    )

    val titulo = when(rutaActual){
        SecondaryRoutes.CARRITO -> "Mi Carrito"
        SecondaryRoutes.NOTIFICACIONES -> "Notificaciones"
        SecondaryRoutes.FAVORITOS -> "Favoritos"
        SecondaryRoutes.COMUNIDAD -> "Comunidad"
        SecondaryRoutes.FICHA_PRODUCTO, SecondaryRoutes.CATALOGO,
        ScreenRoutes.HOME.route, SecondaryRoutes.CAMBIOS_Y_DEVOLUCIONES  -> ""

        else -> pantallaActual.title
    }

    val mostrarIconosTopBar = when(rutaActual) {
        SecondaryRoutes.CAMBIOS_Y_DEVOLUCIONES, SecondaryRoutes.CARRITO, ScreenRoutes.MI_CUENTA.route -> false
        else -> true
    }

    val rutasTopBar = listOf(
        SecondaryRoutes.NOTIFICACIONES,
        SecondaryRoutes.FAVORITOS,
        SecondaryRoutes.CARRITO
    )

    Scaffold(

        topBar = {

            AppTopBar(
                titulo = titulo,
                notificacionesSelected = rutaActual == SecondaryRoutes.NOTIFICACIONES,
                favoritosSelected = rutaActual == SecondaryRoutes.FAVORITOS,
                carritoSelected = rutaActual == SecondaryRoutes.CARRITO,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToCarrito = {

                    navController.navigate(SecondaryRoutes.CARRITO) {
                        launchSingleTop = true
                        restoreState = true

                        if(rutaActual in rutasTopBar) {
                            popUpTo(rutaActual) { inclusive = true }
                        }
                    }
                },
                onNavigateToFavoritos = {

                    navController.navigate(SecondaryRoutes.FAVORITOS) {
                        launchSingleTop = true
                        restoreState = true

                        if(rutaActual in rutasTopBar) {
                            popUpTo(rutaActual) { inclusive = true }
                        }
                    }
                },
                onNavigateToNotificaciones = {

                    navController.navigate(SecondaryRoutes.NOTIFICACIONES) {
                        launchSingleTop = true
                        restoreState = true

                        if(rutaActual in rutasTopBar) {
                            popUpTo(rutaActual) { inclusive = true }
                        }
                    }
                },
                mostrarBotonAtras = !esPantallaPrincipal,
                mostrarActionIcons = mostrarIconosTopBar
            )
        },
        bottomBar = {

            AppBottomBar(
                rutaActual = rutaActual,
                onNavigateTo = { ruta ->

                    while(navController.currentDestination?.route in rutasFlotantes) {
                        navController.popBackStack()
                    }

                    navController.navigate(ruta) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )

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
                startDestination = "graph_home"
            ) {

                navigation(
                    startDestination = ScreenRoutes.HOME.route,
                    route = "graph_home"
                ) {

                    composable(ScreenRoutes.HOME.route) {
                        HomeScreen(
                            productos = DefaultData.listaProductos,
                            categorias = DefaultData.listaCategorias,
                            onNavigateToFichaProducto = { productoId ->

                                viewModel.selectProduct(productoId)
                                navController.navigate(SecondaryRoutes.FICHA_PRODUCTO)
                            },
                            onNavigateToComunidad = { navController.navigate(SecondaryRoutes.COMUNIDAD) },
                            onNavigateToCatalogo = { navController.navigate(SecondaryRoutes.CATALOGO) }
                        )
                    }
                }

                navigation(
                    startDestination = SecondaryRoutes.CATALOGO,
                    route = "graph_catalogo"
                ) {

                    composable(SecondaryRoutes.CATALOGO) {
                        CatalogoScreen(
                            onNavigateToFichaProducto = { productoId ->
                                viewModel.selectProduct(productoId)
                                navController.navigate(SecondaryRoutes.FICHA_PRODUCTO)
                            }
                        )
                    }
                }

                navigation(
                    startDestination = ScreenRoutes.AYUDA.route,
                    route = "graph_ayuda"
                ) {
                    composable(ScreenRoutes.AYUDA.route) {
                        AyudaScreen(
                            onNavigateToDevoluciones = {
                                navController.navigate(SecondaryRoutes.CAMBIOS_Y_DEVOLUCIONES)
                            }
                        )
                    }

                    composable(SecondaryRoutes.CAMBIOS_Y_DEVOLUCIONES) {
                        CambiosYDevolucionesScreen()
                    }
                }

                navigation(
                    startDestination = ScreenRoutes.CATEGORIAS.route,
                    route = "graph_categorias"
                ) {

                    composable(ScreenRoutes.CATEGORIAS.route) {
                        CategoriasScreen()
                    }
                }

                navigation(
                    startDestination = ScreenRoutes.MI_CUENTA.route,
                    route = "graph_mi_cuenta"
                ) {
                    composable(ScreenRoutes.MI_CUENTA.route) {
                        MiCuentaScreen()
                    }
                }

                navigation(
                    startDestination = ScreenRoutes.LOOKS.route,
                    route = "graph_looks"
                ) {
                    composable(ScreenRoutes.LOOKS.route) {
                        LooksScreen()
                    }
                }


                composable(SecondaryRoutes.FICHA_PRODUCTO) {
                    FichaProductoScreen(
                        viewModel = viewModel
                    )
                }

                composable(SecondaryRoutes.COMUNIDAD) {
                    ComunidadScreen()
                }


                composable(SecondaryRoutes.CARRITO) {
                    CarritoScreen(
                        onNavigateToFichaProducto = { productoId ->

                            viewModel.selectProduct(productoId)
                            navController.navigate(SecondaryRoutes.FICHA_PRODUCTO)
                        }
                    )
                }


                composable(SecondaryRoutes.NOTIFICACIONES) {
                    NotificacionesScreen()
                }

                composable(SecondaryRoutes.FAVORITOS) {
                    FavoritosScreen()
                }
            }
        }
    }
}