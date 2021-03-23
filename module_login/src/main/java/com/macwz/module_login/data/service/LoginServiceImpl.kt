package com.macwz.module_login.data.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.macwz.common.router.RouterPath
import com.macwz.common.router.provider.ILoginService

@Route(path = RouterPath.LOGIN_SERVICE, name = "登录")
class LoginServiceImpl : ILoginService {
    override fun toLogin(param: String) {
        ARouter.getInstance().build(RouterPath.LOGIN_MAIN)
            .withString("key_login", param)
            .navigation()
    }

    override fun init(context: Context?) {
        //服务注入时会调用
    }
}