package com.example.programmatictraining.ui.spash

import com.example.programmatictraining.base.BaseFragment
import com.example.programmatictraining.ui.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment: BaseFragment<SplashLayout, Nothing>() {


    override fun prepareLayout(): SplashLayout {
        return SplashLayout(context = requireContext())
    }


    override fun onViewCreate(layout: SplashLayout) {
        layout.textView.text = "Splash"

        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            (activity as? MainActivity)?.navigateLogin()
        }
    }
}