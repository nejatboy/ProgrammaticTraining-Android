package com.example.programmatictraining.base

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.util.TypedValue
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet



abstract class BaseLayout(context: Context): ConstraintLayout(context) {

    private val set = ConstraintSet()

    protected val Int.dp: Int get() {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()
    }


    init {
        configure()
    }


    private fun configure() {
        setBackgroundColor(Color.WHITE)
        isClickable = true
    }


    protected fun applyConstraints(block: ConstraintSet.() -> Unit) {
        set.clone(this)
        set.block()
        set.applyTo(this)
    }


    protected fun addViews(vararg views: View) {
        views.forEach { view ->
            addView(view)
        }
    }
}