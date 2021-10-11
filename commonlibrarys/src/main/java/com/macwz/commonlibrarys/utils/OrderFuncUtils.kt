package com.macwz.commonlibrarys.utils

import java.util.*

/**
 * 队列，按顺序执行
 */
object OrderFuncUtils {
    private var queueFun = LinkedList<Function>()

    private var currentFun: (() -> Unit?)? = null // 当前任务


    fun addFunc(function: () -> Unit?) {
        val func = Function(function)
        doFunc(func)
    }

    fun finishFunc() {
        doFunc(null)
    }

    fun clear(){
        queueFun.clear()
        currentFun = null
    }

    fun isRuning() = queueFun.size != 0

    private fun doFunc(func: Function?) {
        if (func != null) {
            queueFun.offer(func)
        } else {
            currentFun = null
        }
        if (currentFun == null) {
            if (queueFun.size != 0) {
                val funNow = queueFun.poll()
                currentFun = funNow?.function
                currentFun?.invoke()
            }
        }
    }

    data class Function(var function: () -> Unit? = {})
}