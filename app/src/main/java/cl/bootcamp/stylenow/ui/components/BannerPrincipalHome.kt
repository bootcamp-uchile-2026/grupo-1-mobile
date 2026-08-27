package cl.bootcamp.stylenow.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.bootcamp.stylenow.R

@Composable
fun BannerPrincipalHome(
    titulo: String,
    subTitulo: String,
    textoBoton: String,
    onBotonClick: () -> Unit
){

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {

        ImagenBannerHorizontal(
            imagenId = R.drawable.banner_nueva_coleccion,
            descripcion = "Nueva Colección"
        )

        Text(
            text = "Nueva colección",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .padding(vertical = 12.dp)
        )

        Text(
            text = titulo,
            style = MaterialTheme.typography.displayMedium
        )

        Text(
            text = subTitulo,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(vertical = 12.dp)
        )

        BotonNavegacionHome(
            texto = textoBoton,
            onClick = {
                onBotonClick()
            }
        )
    }
}