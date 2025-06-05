package com.example.programmatictraining

import android.content.Context
import android.widget.FrameLayout


class MainLayout(context: Context): FrameLayout(context) {

    val recyclerView = MovieRecyclerView(context)


    init {
        addView(recyclerView)
    }
}