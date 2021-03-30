package com.macwz.jzproject

import android.os.Bundle
import com.macwz.commonbase.base.BaseActivity
import com.macwz.jzproject.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        //ARouterUtils.startLoginActivity(this,"")
    }

    override fun createObserver() {
    }

}