package com.macwz.module_work

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.macwz.common.router.RouterPath
import com.macwz.module_work.ui.work.WorkFragment

@Route(path = RouterPath.WORK_MAIN)
class WorkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.work_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WorkFragment.newInstance())
                .commitNow()
        }
    }
}