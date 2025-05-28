package com.example.programmatictraining.ui

import android.os.Bundle
import com.example.programmatictraining.base.BaseActivity
import com.example.programmatictraining.ui.spash.SplashFragment


class MainActivity : BaseActivity<MainLayout>() {


    override fun prepareLayout(): MainLayout {
        return MainLayout(context = this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupSplash()
    }


    private fun setupSplash() {
        val splashFragment = SplashFragment()

        supportFragmentManager.beginTransaction()
            .add(layout.container.id, splashFragment)
            .commit()
    }
}