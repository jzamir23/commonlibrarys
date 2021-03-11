package com.macwz.module_home.data.service

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.macwz.module_common.RoutePath
import com.macwz.module_common.componentbase.IComponentService

@Route(path = RoutePath.HOME_SERVICE)
class ComponentServiceImpl:IComponentService {
    override fun getParameterInfo(): Any {
        return "home"
    }

    override fun init(context: Context?) {
        //服务注入时会调用
        Log.i("11111Home", "------service init------")
    }
}