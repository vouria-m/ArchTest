package com.vouria.app.archtest.core.base

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint

open class BaseFragment<T: ViewBinding>: Fragment() {
}