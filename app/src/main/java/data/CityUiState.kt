package com.example.mycityapp.data

data class CityUiState(
    val categories: List<Category> = listOf(),
    val currentCategory: Category = DataSource.defaultCategory,
    val currentReccomendation: Reccomendation = DataSource.defaultReccomendation
)