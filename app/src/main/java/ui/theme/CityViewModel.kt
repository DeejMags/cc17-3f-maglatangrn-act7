package ui.theme

import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.Category
import com.example.mycityapp.data.CityUiState
import com.example.mycityapp.data.DataSource
import com.example.mycityapp.data.Reccomendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CityUiState())
    val uiState: StateFlow<CityUiState> = _uiState.asStateFlow()

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        _uiState.value =
            CityUiState(
                categories = DataSource.categories
            )
    }

    fun updateCurrentCategory(category: Category) {
        _uiState.update {
            it.copy(
                currentCategory = category
            )
        }
    }

    fun updateCurrentReccomendation(reccomendation: Reccomendation) {
        _uiState.update {
            it.copy(
                currentReccomendation = reccomendation
            )
        }
    }
}