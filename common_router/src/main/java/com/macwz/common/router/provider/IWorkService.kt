package com.macwz.common.router.provider

import com.alibaba.android.arouter.facade.template.IProvider

interface IWorkService: IProvider {
    fun toWork(param: String)
}