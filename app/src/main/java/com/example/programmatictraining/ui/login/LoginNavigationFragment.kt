package com.example.programmatictraining.ui.login

import androidx.fragment.app.FragmentTransaction
import com.example.programmatictraining.base.BaseFragment
import com.example.programmatictraining.ui.login.signIn.SignInFragment
import com.example.programmatictraining.ui.login.signUp.SignUpFragment


class LoginNavigationFragment: BaseFragment<LoginNavigationLayout, Nothing>() {

    private val signInFragment = SignInFragment()
    private val signUpFragment = SignUpFragment()


    override fun prepareLayout(): LoginNavigationLayout {
        return LoginNavigationLayout(context = requireContext())
    }


    override fun onViewCreate(layout: LoginNavigationLayout) {
        childFragmentManager.beginTransaction()
            .add(layout.container.id, signInFragment)
            .commit()
    }


    fun navigateSignUp() {
        childFragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .add(layout.container.id, signUpFragment)
            .addToBackStack(null)
            .commit()
    }
}