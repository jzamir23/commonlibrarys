package com.macwz.module_my

import com.alibaba.android.arouter.launcher.ARouter
import com.macwz.commonlibrarys.base.BaseApp

class MyApplication : BaseApp() {
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