package com.example.programmatictraining

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    private lateinit var layout: MainLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layout = MainLayout(context = this)
        setContentView(layout)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(layout) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setData()
    }


    private fun setData() {
        val pokemons = arrayListOf(
            Pokemon(name = "Bulbasaur", imageId = R.drawable.bulbasaur),
            Pokemon(name = "Squirtle", imageId = R.drawable.squirtle),
            Pokemon(name = "Jigglypuff", imageId = R.drawable.jigglypuff),
            Pokemon(name = "Meowth", imageId = R.drawable.meowth),
            Pokemon(name = "Psyduck", imageId = R.drawable.psyduck),
            Pokemon(name = "Machop", imageId = R.drawable.machop),
            Pokemon(name = "Snorlax", imageId = R.drawable.snorlax),
            Pokemon(name = "Diglett", imageId = R.drawable.diglett),
            Pokemon(name = "Koffing", imageId = R.drawable.koffing),
        )

        layout.recyclerView.pokemonAdapter?.pokemons = pokemons
    }
}