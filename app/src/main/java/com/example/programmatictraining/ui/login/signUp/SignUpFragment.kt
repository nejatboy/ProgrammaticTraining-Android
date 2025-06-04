package com.example.programmatictraining.ui.login.signUp

import com.example.programmatictraining.base.BaseFragment
import com.example.programmatictraining.ui.login.LoginNavigationFragment


class SignUpFragment: BaseFragment<SignUpLayout, LoginNavigationFragment>() {


    override fun prepareLayout(): SignUpLayout {
        return SignUpLayout(context = requireContext())
    }


    override fun onViewCreate(layout: SignUpLayout) {
        layout.button.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
    }
}