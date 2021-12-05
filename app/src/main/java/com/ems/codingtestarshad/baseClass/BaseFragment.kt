package com.ems.codingtestarshad.baseClass

import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {

    protected abstract val viewModel: BaseViewModel
}