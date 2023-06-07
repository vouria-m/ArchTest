package com.vouria.app.archtest.login.ui.view.activity

import android.content.Context
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.vouria.app.archtest.R
import com.vouria.app.archtest.core.base.BaseActivity
import com.vouria.app.archtest.core.data.local.AppDataBase
import com.vouria.app.archtest.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>() {

//    lateinit var context1: Context
    private lateinit var dataBase: AppDataBase
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
//        dataBase=AppDataBase.getDatabase(context1)
    }
    //for test commit from home
    //for test commit from company
}