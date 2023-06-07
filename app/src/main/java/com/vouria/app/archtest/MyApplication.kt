package com.vouria.app.archtest

import android.app.Application
import dagger.Module
import dagger.hilt.android.HiltAndroidApp

//@Module
@HiltAndroidApp
class MyApplication : Application(){}