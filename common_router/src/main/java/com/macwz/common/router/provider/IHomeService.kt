package com.macwz.common.router.provider

import com.alibaba.android.arouter.facade.template.IProvider

interface IHomeService : IProvider {
    fun toHome(param: String)
}