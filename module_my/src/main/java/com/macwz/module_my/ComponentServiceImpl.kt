package com.macwz.module_my

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.macwz.module_common.RoutePath
import com.macwz.module_common.componentbase.IComponentService

@Route(path = RoutePath.MY_SERVICE)
class ComponentServiceImpl:IComponentService {
    override fun getParameterInfo(): Any {
        return "my"
    }

    override fun init(context: Context?) {
        //服务注入时会调用
    }
}