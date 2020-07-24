package com.example.myapplication.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

open class BaseFragment: Fragment() {

    fun <T : ViewModel> getViewModel(className: Class<T>): T {
        return ViewModelProviders.of(activity!!).get(className)
    }

    fun <T : ViewModel> getSelfViewModel(className: Class<T>): T {
        return ViewModelProviders.of(this).get(className)
    }

}
