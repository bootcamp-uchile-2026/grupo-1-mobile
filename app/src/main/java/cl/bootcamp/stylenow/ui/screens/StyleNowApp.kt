package cl.bootcamp.stylenow.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StyleNowApp(

) {
    Scaffold(

        topBar = {

            //Modularizar a /components
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        //Por ahora título fijo
                        text = "StyleNow"
                    )
                },

                navigationIcon = {

                    //Modular luego a /components
                    IconButton(
                        onClick = {
                            //Ir hacia atrás, funcion sacada del viewmodel
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                },

                actions = {

                    //Modular luego a /components
                    IconButton(
                        onClick = {
                            //Navegar a Screen Carrito, funcion sacada del viewmodel
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ShoppingCart,
                            contentDescription = "Ver carrito",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },

        bottomBar = {

            //Modularizar a /components
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            ) {

                val secciones = listOf(
                    ScreenRoutes.HOME,
                    ScreenRoutes.CATEGORIAS,
                    ScreenRoutes.MI_CUENTA,
                    ScreenRoutes.AYUDA
                )

                secciones.forEach { seccion ->

                    NavigationBarItem(
                        selected = false, //Por ahora false, luego validar con la ruta actual
                        onClick = { /* onNavigateTo() sacado del viewmodel */ },
                        icon = { Icon(seccion.unSelectedIcon, contentDescription = seccion.title) },
                        label = { Text(seccion.title) },
                        colors = NavigationBarItemColors(
                            selectedIconColor = MaterialTheme.colorScheme.onSurface,
                            selectedTextColor = MaterialTheme.colorScheme.onSurface,
                            selectedIndicatorColor = MaterialTheme.colorScheme.onSurface,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurface,
                            disabledIconColor = MaterialTheme.colorScheme.onSurface,
                            disabledTextColor = MaterialTheme.colorScheme.onSurface
                        )
                    )
                }
            }
        },

        snackbarHost = { /*TODO*/ },

        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = innerPadding)
        ) {

        }
    }
}