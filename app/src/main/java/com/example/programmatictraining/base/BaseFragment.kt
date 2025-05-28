package com.example.programmatictraining.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment



@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<L: BaseLayout, P: Fragment>: Fragment() {

    protected val layout: L get() = view as L
    protected val parent: P? get() = parentFragment as? P


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return prepareLayout()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onViewCreate(view as L)
        super.onViewCreated(view, savedInstanceState)
    }


    abstract fun prepareLayout() : L


    abstract fun onViewCreate(layout: L)
}