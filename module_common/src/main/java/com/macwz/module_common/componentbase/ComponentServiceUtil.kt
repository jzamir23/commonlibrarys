package com.macwz.module_common.componentbase

import com.alibaba.android.arouter.launcher.ARouter
import com.macwz.module_common.RoutePath

object ComponentServiceUtil {
    fun navigateHomePage(param: String) {
        ARouter.getInstance().build(RoutePath.HOME_LOGIN)
            .withString("key_home", param)
            .navigation()
    }

    fun navigateMyPage(param: String) {
        ARouter.getInstance().build(RoutePath.MY_MAIN)
            .withString("key_my", param)
            .navigation()
    }

    fun navigatePage(path: String, paramJson: String) {
        ARouter.getInstance().build(path)
            .withString("key_json", paramJson)
            .navigation()
    }

    fun getComponentService(servicePath: String): IComponentService? {
        val ar = ARouter.getInstance().build(servicePath).navigation()
        if( ar is IComponentService){
            return ar
        }
        return null
    }

    fun getParameterInfo(servicePath: String): Any {
        return getComponentService(servicePath)?.getParameterInfo() ?: "param is null"
    }
}