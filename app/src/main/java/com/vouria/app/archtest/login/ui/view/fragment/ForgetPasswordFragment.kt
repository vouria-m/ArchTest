package com.vouria.app.archtest.login.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.vouria.app.archtest.R
import com.vouria.app.archtest.core.base.BaseFragment
import com.vouria.app.archtest.databinding.FragmentForgetPasswordBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ForgetPasswordFragment : BaseFragment<FragmentForgetPasswordBinding>() {

    private lateinit var binding: FragmentForgetPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_forget_password, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

}