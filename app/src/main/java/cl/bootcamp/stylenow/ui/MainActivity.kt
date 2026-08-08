package cl.bootcamp.stylenow.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.bootcamp.stylenow.ui.screens.ScreenEnum
import cl.bootcamp.stylenow.ui.theme.StyleNowTheme
import cl.bootcamp.stylenow.viewmodel.MainScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel = MainScreenViewModel()
        setContent {
            StyleNowTheme {
                MainScreen(viewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainScreenViewModel) {

    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = {

            TopAppBar(
                title = {
                    Text(
                        text = viewModel.actualScreen.titulo,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        },
        bottomBar =  {

            BottomAppBar {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ){

                    NavigationBar() {

                        val home = ScreenEnum.HOME

                        NavigationBarItem(
                            selected = viewModel.actualScreen == home,
                            onClick = { viewModel.changeScreen(home) },
                            icon = { Icon(home.icono, contentDescription = home.titulo) },
                            label = { Text(text = home.titulo) }
                        )
                    }
                }
            }
        },

        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        modifier = Modifier.fillMaxSize()

    ) { innerPadding ->

        //TODO: Eliminar, solo está para omitir el error del innerPadding
        Column(modifier = Modifier.padding(innerPadding)) {

        }

        when(viewModel.actualScreen) {

            ScreenEnum.HOME -> { /*TODO: Aquí va a la Screen Home y se le pasa el modifier con el innerPading*/ }
        }
    }
}
