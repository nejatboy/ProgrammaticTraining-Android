package com.example.programmatictraining.base

import android.content.Context
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet



abstract class BaseLayout(context: Context): ConstraintLayout(context) {

    protected val set = ConstraintSet()
}