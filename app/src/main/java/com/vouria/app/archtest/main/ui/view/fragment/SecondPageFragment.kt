package com.vouria.app.archtest.main.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.vouria.app.archtest.R
import com.vouria.app.archtest.databinding.FragmentSecondPageBinding

class SecondPageFragment : Fragment() {
    private lateinit var binding: FragmentSecondPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second_page, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

}