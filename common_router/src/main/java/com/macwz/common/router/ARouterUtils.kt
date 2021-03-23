package com.macwz.common.router

import android.app.Activity
import com.alibaba.android.arouter.facade.template.IProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.macwz.common.router.provider.IHomeService
import com.macwz.common.router.provider.ILoginService
import com.macwz.common.router.provider.IMyService
import com.macwz.common.router.provider.IWorkService

object ARouterUtils {
    inline fun <reified T : IProvider> getComponentService(servicePath: String): T? {
        val service = ARouter.getInstance().build(servicePath).navigation()
        return service as? T
    }

    fun startWorkActivity(activity: Activity, paramsJson: String) {
        getComponentService<IWorkService>(RouterPath.WORK_SERVICE)?.toWork(paramsJson)
        activity.finish()
    }

    fun startHomeActivity(activity: Activity, paramsJson: String) {
        getComponentService<IHomeService>(RouterPath.HOME_SERVICE)?.toHome(paramsJson)
        activity.finish()
    }

    fun startMyActivity(activity: Activity, paramsJson: String) {
        getComponentService<IMyService>(RouterPath.MY_SERVICE)?.toMy(paramsJson)
        activity.finish()
    }

    fun startLoginActivity(activity: Activity, paramsJson: String) {
        getComponentService<ILoginService>(RouterPath.LOGIN_SERVICE)?.toLogin(paramsJson)
        activity.finish()
    }
}