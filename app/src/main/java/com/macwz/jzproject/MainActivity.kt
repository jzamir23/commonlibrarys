package com.macwz.jzproject

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.blankj.utilcode.util.ToastUtils
import com.macwz.commonbase.base.BaseActivity
import com.macwz.commonlibrarys.network.manager.NetState
import com.macwz.jzproject.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    var exitTime = 0L

    override fun layoutId() = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        onBackPressedDispatcher.addCallback(this, object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                val nav = Navigation.findNavController(this@MainActivity, R.id.host_fragment)
                if (nav.currentDestination != null && nav.currentDestination!!.id != R.id.homefragment) {
                    //如果当前界面不是主页，那么直接调用返回即可
                    nav.navigateUp()
                } else {
                    //是主页
                    if (System.currentTimeMillis() - exitTime > 2000) {
                        ToastUtils.showShort("再按一次退出程序")
                        exitTime = System.currentTimeMillis()
                    } else {
                        finish()
                    }
                }
            }
        })
    }

    override fun createObserver() {
    }

    override fun onNetworkStateChanged(netState: NetState) {
        if(netState.isSuccess){
            ToastUtils.showShort("已连接网络")
        }else{
            ToastUtils.showShort("网络已断开")
        }
    }

}