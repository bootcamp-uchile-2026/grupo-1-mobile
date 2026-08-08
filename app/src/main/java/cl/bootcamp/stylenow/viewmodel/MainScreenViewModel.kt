package cl.bootcamp.stylenow.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cl.bootcamp.stylenow.ui.screens.ScreenEnum

class MainScreenViewModel : ViewModel() {

    var actualScreen by mutableStateOf(ScreenEnum.HOME)

    fun changeScreen(newScreen: ScreenEnum): ScreenEnum {
        actualScreen = newScreen
        return actualScreen
    }
}