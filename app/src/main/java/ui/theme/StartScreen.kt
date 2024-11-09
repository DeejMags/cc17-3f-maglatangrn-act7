package ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import com.example.mycityapp.data.Category
import com.example.mycityapp.data.CityUiState

@Composable
fun StartScreen(
    uiState: CityUiState,
    onCategoryClicked: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    val categories = uiState.categories

    LazyColumn(
        modifier = modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            CategoryListItem(
                category = category,
                onCategoryClicked = onCategoryClicked
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryListItem(
    category: Category,
    onCategoryClicked: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        onClick = { onCategoryClicked(category) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(category.picture),
                contentDescription = null,
                modifier = modifier
                    .size(64.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(category.name),
                fontWeight = FontWeight.Bold,
                modifier =  modifier.padding(start = 12.dp)
            )
        }
    }
}