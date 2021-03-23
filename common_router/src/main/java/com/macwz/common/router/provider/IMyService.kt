package com.macwz.common.router.provider

import com.alibaba.android.arouter.facade.template.IProvider

interface IMyService:IProvider {
    fun toMy(param: String)
}