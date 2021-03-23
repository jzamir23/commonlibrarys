package com.macwz.jzproject

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.macwz.common.router.RouterPath
import com.macwz.common.router.provider.IMyService
import com.macwz.common.router.ARouterUtils
import com.macwz.common.router.provider.ILoginService

@Route(path = RouterPath.APP_MAIN)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv_hello).setOnClickListener {
            ARouterUtils.getComponentService<ILoginService>(RouterPath.LOGIN_SERVICE)?.toLogin("")
        }
    }
}