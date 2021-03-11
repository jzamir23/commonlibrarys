package com.macwz.module_common.componentbase

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.macwz.module_common.RoutePath

@Interceptor(priority = 1, name = "组件跳转拦截")
class BaseInterceptor: IInterceptor{
    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        if(postcard?.path?.contains(RoutePath.HOME_LOGIN) == true){
            Log.d("BaseInterceptor", "拦截到向HOME_LOGIN跳转")
        }else{
            Log.d("BaseInterceptor", "非拦截跳转path:${postcard?.path}")
            //callback?.onContinue(postcard)//继续放行
        }
        callback?.onContinue(postcard)//继续放行
    }

    override fun init(context: Context?) {
        //拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        Log.d("BaseInterceptor", "Router Interceptor init")
    }
}