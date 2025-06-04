package com.example.programmatictraining.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


interface BaseFragmentContract {
    fun onBackPressed()
}



@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<L: BaseLayout, P: BaseFragmentContract>: Fragment(), BaseFragmentContract {

    protected val layout: L get() = view as L
    protected val parent: P? get() = parentFragment as? P


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return prepareLayout()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreate(view as L)
    }


    abstract fun prepareLayout() : L


    abstract fun onViewCreate(layout: L)


    override fun onBackPressed() {
        if (childFragmentManager.popBackStackImmediate()) {
            return
        }

        if (parentFragmentManager.popBackStackImmediate()) {
            return
        }

        activity?.finish()
    }
}