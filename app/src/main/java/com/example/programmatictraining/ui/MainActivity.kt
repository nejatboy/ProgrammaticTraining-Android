package com.example.programmatictraining.ui

import android.os.Bundle
import com.example.programmatictraining.base.BaseActivity
import com.example.programmatictraining.ui.movie.MovieFragment


class MainActivity : BaseActivity<MainLayout>() {


    override fun prepareLayout(): MainLayout {
        return MainLayout(context = this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieFragment = MovieFragment()

        supportFragmentManager.beginTransaction()
            .add(layout.container.id, movieFragment)
            .commit()
    }
}