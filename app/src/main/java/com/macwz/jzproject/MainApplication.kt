package com.macwz.jzproject

import com.alibaba.android.arouter.launcher.ARouter
import com.macwz.commonlibrarys.BaseApp

class MainApplication : BaseApp() {
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