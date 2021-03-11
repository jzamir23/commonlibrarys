package com.macwz.jzproject

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.macwz.module_common.RoutePath
import com.macwz.module_common.componentbase.ComponentServiceUtil

@Route(path = RoutePath.APP_MAIN)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv_hello).setOnClickListener {
            ComponentServiceUtil.navigateMyPage("111")
        }
    }
}