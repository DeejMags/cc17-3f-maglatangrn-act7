package ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.mycityapp.data.CityUiState
import com.example.mycityapp.data.Reccomendation

@Composable
fun ReccomendationScreen(
    uiState: CityUiState,
    onReccomendationClicked: (Reccomendation) -> Unit,
    modifier: Modifier = Modifier
) {
    val reccomendations = uiState.currentCategory.reccomendationList

    LazyColumn(
        modifier = modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(reccomendations) { reccomendation ->
            ReccomendationListItem(
                reccomendation = reccomendation,
                onReccomendationClicked = onReccomendationClicked
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReccomendationListItem(
    reccomendation: Reccomendation,
    onReccomendationClicked: (Reccomendation) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        onClick = { onReccomendationClicked(reccomendation) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(reccomendation.image),
                contentDescription = null,
                modifier = modifier
                    .size(64.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier =  modifier.padding(start = 12.dp)
            ) {
                Text(
                    text = stringResource(reccomendation.title),
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(reccomendation.text),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}