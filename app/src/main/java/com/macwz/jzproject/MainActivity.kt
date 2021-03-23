package com.macwz.jzproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.macwz.common.router.ARouterUtils
import com.macwz.common.router.RouterPath

@Route(path = RouterPath.APP_MAIN)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ARouterUtils.startLoginActivity(this,"")
    }
}