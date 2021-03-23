package com.macwz.common.router.provider

import com.alibaba.android.arouter.facade.template.IProvider

interface ILoginService: IProvider {
    fun toLogin(param: String)
}