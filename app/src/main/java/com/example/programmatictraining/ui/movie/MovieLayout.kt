package com.example.programmatictraining.ui.movie

import android.content.Context
import com.example.programmatictraining.base.BaseLayout



class MovieLayout(context: Context) : BaseLayout(context) {

    val recyclerView = MovieRecyclerView(context)


    init {
        addView(recyclerView)
    }
}