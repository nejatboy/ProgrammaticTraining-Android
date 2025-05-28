package com.example.programmatictraining.ui.spash

import android.graphics.Color
import com.example.programmatictraining.R
import com.example.programmatictraining.base.BaseFragment



class SplashFragment: BaseFragment<SplashLayout, Nothing>() {


    override fun prepareLayout(): SplashLayout {
        return SplashLayout(context = requireContext())
    }


    override fun onViewCreate(layout: SplashLayout) {
        layout.setBackgroundColor(Color.MAGENTA)

        setupSplashText()
    }


    private fun setupSplashText() {
        layout.textView.setText(R.string.app_name)
    }
}