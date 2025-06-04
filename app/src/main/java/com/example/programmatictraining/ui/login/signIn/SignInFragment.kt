package com.example.programmatictraining.ui.login.signIn

import com.example.programmatictraining.base.BaseFragment
import com.example.programmatictraining.ui.login.LoginNavigationFragment


class SignInFragment: BaseFragment<SignInLayout, LoginNavigationFragment>() {


    override fun prepareLayout(): SignInLayout {
        return SignInLayout(context = requireContext())
    }


    override fun onViewCreate(layout: SignInLayout) {
        layout.button.setOnClickListener {
            parent?.navigateSignUp()
        }
    }
}