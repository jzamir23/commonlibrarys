package com.macwz.module_common

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initARouter()
    }

    private fun initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}