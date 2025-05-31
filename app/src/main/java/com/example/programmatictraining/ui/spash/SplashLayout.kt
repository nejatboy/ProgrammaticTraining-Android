package com.example.programmatictraining.ui.spash

import android.content.Context
import android.graphics.Typeface
import android.util.TypedValue
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import com.example.programmatictraining.base.BaseLayout


class SplashLayout(context: Context) : BaseLayout(context) {

    val textView = TextView(context)


    init {
        textView.id = generateViewId()
        textView.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        textView.typeface = Typeface.DEFAULT_BOLD
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

        addView(textView)

        set.clone(this)
        set.connect(textView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 20.dp)
        set.connect(textView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 20.dp)
        set.centerVertically(textView.id, ConstraintSet.PARENT_ID)
        set.applyTo(this)
    }
}