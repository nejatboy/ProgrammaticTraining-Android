package com.example.programmatictraining

import android.content.Context
import android.widget.FrameLayout


class MainLayout(context: Context): FrameLayout(context) {

    val recyclerView = PokemonRecyclerView(context)


    init {
        addView(recyclerView)
    }
}