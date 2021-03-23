package com.macwz.module_home

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.macwz.common.router.RouterPath
import com.macwz.common.router.provider.IHomeService

@Route(path = RouterPath.HOME_SERVICE, name = "首页")
class HomeServiceImpl : IHomeService {
    override fun toHome(param: String) {
        ARouter.getInstance().build(RouterPath.HOME_MAIN)
            .withString("key_home", param)
            .navigation()
    }

    override fun init(context: Context?) {
        //服务注入时会调用
    }
}