package com.example.programmatictraining.base

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet



abstract class BaseLayout(context: Context): ConstraintLayout(context) {

    protected val set = ConstraintSet()

    protected val Int.dp: Int get() {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()
    }
}