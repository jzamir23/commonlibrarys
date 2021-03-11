package com.macwz.module_common.componentbase

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * 组件对外暴露的服务
 */
interface IComponentService : IProvider {
    /**
     * 定义组件之间数据通信的接口
     */
    fun getParameterInfo():Any
}