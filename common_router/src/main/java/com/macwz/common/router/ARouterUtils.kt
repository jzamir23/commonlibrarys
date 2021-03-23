package com.macwz.common.router

import com.alibaba.android.arouter.facade.template.IProvider
import com.alibaba.android.arouter.launcher.ARouter

object ARouterUtils {
    inline fun <reified T: IProvider> getComponentService(servicePath: String): T? {
        val service = ARouter.getInstance().build(servicePath).navigation()
        return service as? T
    }
}