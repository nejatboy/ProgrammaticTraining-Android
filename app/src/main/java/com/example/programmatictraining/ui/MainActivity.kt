package com.example.programmatictraining.ui

import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.programmatictraining.base.BaseActivity
import com.example.programmatictraining.ui.login.LoginNavigationFragment
import com.example.programmatictraining.ui.spash.SplashFragment


class MainActivity : BaseActivity<MainLayout>() {

    private val splashFragment = SplashFragment()
    private val loginNavigationFragment = LoginNavigationFragment()


    override fun prepareLayout(): MainLayout {
        return MainLayout(context = this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupSplash()
    }


    private fun setupSplash() {
        supportFragmentManager.beginTransaction()
            .add(layout.container.id, splashFragment)
            .commit()
    }


    fun navigateLogin() {
        supportFragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .add(layout.container.id, loginNavigationFragment)
            .addToBackStack(null)
            .commit()
    }
}