package cl.bootcamp.stylenow.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.bootcamp.stylenow.R

@Composable
fun BannerPrincipalHome(
    titulo: String,
    subTitulo: String,
    textoBoton: String
){

    Column(
    ) {

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
            text = titulo,
            style = MaterialTheme.typography.titleLarge,
            fontSize = 32.sp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

        Text(
            text = subTitulo,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(vertical = 12.dp, horizontal = 16.dp)
        )

        BotonNavegacionHome(
            texto = textoBoton,
            onClick = {}
        )
    }
}