package com.example.programmatictraining.ui.spash

import android.content.Context
import android.graphics.Typeface
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintSet
import com.example.programmatictraining.base.BaseLayout



class SplashLayout(context: Context) : BaseLayout(context) {

    val textView = AppCompatTextView(context)


    init {
        textView.id = generateViewId()
        textView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        textView.typeface = Typeface.DEFAULT_BOLD
        textView.textSize = 30f

        addView(textView)

        set.clone(this)
        set.centerVertically(textView.id, ConstraintSet.PARENT_ID)
        set.centerHorizontally(textView.id, ConstraintSet.PARENT_ID)
        set.applyTo(this)
    }
}