package ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mycityapp.data.CityUiState

@Composable
fun DetailsScreen(
    uiState: CityUiState,
    modifier: Modifier = Modifier
) {
    val reccomendation = uiState.currentReccomendation

    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(reccomendation.image),
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
                .height(100.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(reccomendation.text),
            modifier =  modifier.padding(12.dp)
        )
    }
}