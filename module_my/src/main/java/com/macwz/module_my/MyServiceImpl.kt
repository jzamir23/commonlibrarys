package com.macwz.module_my

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.macwz.common.router.RouterPath
import com.macwz.common.router.provider.IMyService

@Route(path = RouterPath.MY_SERVICE, name = "我的")
class MyServiceImpl : IMyService {
    override fun toMy(param: String) {
        ARouter.getInstance().build(RouterPath.MY_MAIN)
            .withString("key_my", param)
            .navigation()
    }

    override fun init(context: Context?) {
        //服务注入时会调用
    }
}