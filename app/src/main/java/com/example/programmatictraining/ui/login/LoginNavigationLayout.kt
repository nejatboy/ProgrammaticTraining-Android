package com.example.programmatictraining.ui.login

import android.content.Context
import android.widget.FrameLayout
import com.example.programmatictraining.base.BaseLayout


class LoginNavigationLayout(context: Context) : BaseLayout(context) {

    val container = FrameLayout(context)


    init {
        container.id = generateViewId()
        container.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)

        addView(container)
    }
}