package com.macwz.jzproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alibaba.android.arouter.launcher.ARouter
import com.macwz.common.router.RouterPath
import com.macwz.commonbase.base.BaseFragment
import com.macwz.jzproject.R
import com.macwz.jzproject.databinding.FragmentMainBinding

class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding>() {
    override fun layoutId() = R.layout.fragment_main

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.mainViewpager.isUserInputEnabled = false
        mDatabind.mainViewpager.offscreenPageLimit = 3
        mDatabind.mainViewpager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = 3

            override fun createFragment(position: Int): Fragment {
                when (position) {
                    0 -> {
                        return ARouter.getInstance().build(RouterPath.HOME_MAIN)
                            .navigation() as Fragment
                    }
                    1 -> {
                        return ARouter.getInstance().build(RouterPath.WORK_MAIN)
                            .navigation() as Fragment
                    }
                    2 -> {
                        return ARouter.getInstance().build(RouterPath.MY_MAIN)
                            .navigation() as Fragment
                    }
                    else -> return ARouter.getInstance().build(RouterPath.HOME_MAIN)
                        .navigation() as Fragment
                }
            }
        }

    }

}