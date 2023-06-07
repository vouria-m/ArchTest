package com.vouria.app.archtest.core.base

import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint

open class BaseActivity<T:ViewBinding>: AppCompatActivity() {
}