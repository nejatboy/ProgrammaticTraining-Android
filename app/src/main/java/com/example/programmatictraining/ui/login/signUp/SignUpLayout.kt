package com.example.programmatictraining.ui.login.signUp

import android.content.Context
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import com.example.programmatictraining.base.BaseLayout


class SignUpLayout(context: Context) : BaseLayout(context) {

    val textView = TextView(context)
    val button = Button(context)

    init {
        textView.id = generateViewId()
        textView.text = "Sign Up"
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

        button.id = generateViewId()
        button.text = "SIGN IN"

        addViews(textView, button)

        applyConstraints {
            centerHorizontally(textView.id, ConstraintSet.PARENT_ID)
            centerVertically(textView.id, ConstraintSet.PARENT_ID)

            centerHorizontally(button.id, ConstraintSet.PARENT_ID)
            connect(button.id, ConstraintSet.TOP, textView.id, ConstraintSet.BOTTOM)
            connect(button.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        }
    }
}