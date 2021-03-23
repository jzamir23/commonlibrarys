package com.macwz.module_home

import com.alibaba.android.arouter.launcher.ARouter
import com.macwz.commonlibrarys.BaseApp

class HomeApplication : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.isModule){
            initARouter()
        }
    }

    private fun initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}