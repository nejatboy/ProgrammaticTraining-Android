package com.example.programmatictraining.base

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


abstract class BaseActivity<L: BaseLayout>: AppCompatActivity() {

    protected lateinit var layout: L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layout = prepareLayout()
        setContentView(layout)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(layout) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        onBackPressedDispatcher.addCallback(this, OnBackPressing(::onBackClicked))
    }


    abstract fun prepareLayout(): L


    private fun onBackClicked() {
        (supportFragmentManager.fragments.lastOrNull() as? BaseFragmentContract)?.onBackPressed()
    }
}


private class OnBackPressing(private val listener: () -> Unit): OnBackPressedCallback(enabled = true) {


    override fun handleOnBackPressed() {
        listener.invoke()
    }
}