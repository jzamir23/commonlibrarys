package com.macwz.module_login

import com.alibaba.android.arouter.launcher.ARouter
import com.macwz.commonlibrarys.base.BaseApp

class LoginApplication : BaseApp() {
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