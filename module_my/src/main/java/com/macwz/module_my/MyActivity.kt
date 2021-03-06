package com.macwz.module_my

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.macwz.common.router.RouterPath
import com.macwz.module_my.ui.main.MyFragment

@Route(path = RouterPath.MY_MAIN)
class MyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MyFragment.newInstance())
                .commitNow()
        }
    }
}