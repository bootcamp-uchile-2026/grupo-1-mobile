package cl.bootcamp.stylenow.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun ImagenBannerHorizontal(
    imagenId: Int,
    descripcion: String
) {

    Image(
        painter = painterResource(id = imagenId),
        contentDescription = descripcion,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2f)
    )
}