package cl.bootcamp.stylenow.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.bootcamp.stylenow.data.DefaultData
import cl.bootcamp.stylenow.data.Producto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _selectedProductId = MutableStateFlow<String?>(null)
    val selectedProductId: StateFlow<String?> = _selectedProductId.asStateFlow()

    val selectedProduct: StateFlow<Producto?> = _selectedProductId.map { id ->
        DefaultData.listaProductos.find { it.id == id }

    }.let { flow ->
        val initialSelected = DefaultData.listaProductos.find { it.id == _selectedProductId.value }
        MutableStateFlow(initialSelected).apply {

            viewModelScope.launch {
                flow.collect { value = it }
            }
        }
    }

    fun selectProduct(id: String) {
        _selectedProductId.value = id
    }
}