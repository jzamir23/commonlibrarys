package com.macwz.module_work

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.macwz.common.router.RouterPath
import com.macwz.common.router.provider.IWorkService

@Route(path = RouterPath.WORK_SERVICE, name = "工作")
class WorkServiceImpl : IWorkService {
    override fun toWork(param: String) {
        ARouter.getInstance().build(RouterPath.WORK_MAIN)
            .withString("key_work", param)
            .navigation()
    }

    override fun init(context: Context?) {
        //服务注入时会调用
    }
}