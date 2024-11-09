package com.example.mycityappmaglatangcc17_3f

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    private lateinit var categoryListView: ListView
    private val categories = listOf("Category 1", "Category 2", "Category 3", "Category 4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categoryListView = findViewById(R.id.categoryListView)
        val categoryAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, categories)
        categoryListView.adapter = categoryAdapter

        categoryListView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, RecommendationActivity::class.java)
            intent.putExtra("category", categories[position])
            startActivity(intent)
        }
    }
}
