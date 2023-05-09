package com.vouria.app.archtest.login.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.vouria.app.archtest.R
import com.vouria.app.archtest.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        binding.txtGoToMain.setOnClickListener {
            navController.navigate(R.id.action_loginFragment2_to_mainActivity2)
        }
        binding.txtGoToForgetPage.setOnClickListener {
            navController.navigate(R.id.action_loginFragment2_to_forgetPasswordFragment)
        }
    }
}