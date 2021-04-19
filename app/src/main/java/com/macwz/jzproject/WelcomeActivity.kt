package com.macwz.jzproject

import android.content.Intent
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.macwz.commonbase.base.BaseActivity
import com.macwz.commonlibrarys.base.viewmodel.BaseViewModel
import com.macwz.commonlibrarys.utils.MmkvUtils
import com.macwz.commonlibrarys.utils.ext.gone
import com.macwz.commonlibrarys.utils.ext.visible
import com.macwz.jzproject.databinding.ActivityWelcomeBinding
import com.zhpan.bannerview.BannerViewPager

class WelcomeActivity : BaseActivity<BaseViewModel, ActivityWelcomeBinding>() {

    private var resList = arrayOf("item1", "item2", "item3")

    private lateinit var mViewPager: BannerViewPager<String, WelcomeBannerViewHolder>

    override fun layoutId() = R.layout.activity_welcome

    override fun initView(savedInstanceState: Bundle?) {
//        //防止出现按Home键回到桌面时，再次点击重新进入该界面bug
//        if (intent.flags and Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT !== 0) {
//            finish()
//            return
//        }
        mDatabind.click = ProxyClick()
        //mDatabind.welcomeBaseview.setBackgroundColor(SettingUtil.getColor(this))
        mViewPager = findViewById(R.id.banner_view)
        if (MmkvUtils.getBoolean("first", true)) {
            //是第一次打开App 显示引导页
            mDatabind.welcomeImage.gone()
            mViewPager.apply {
                adapter = WelcomeBannerAdapter()
                setLifecycleRegistry(lifecycle)
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        if (position == resList.size - 1) {
                            mDatabind.welcomeJoin.visible()
                        } else {
                            mDatabind.welcomeJoin.gone()
                        }
                    }
                })
                create(resList.toList())
            }
        } else {
            //不是第一次打开App 0.3秒后自动跳转到主页
            mDatabind.welcomeImage.visible()
            mViewPager.postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                //带点渐变动画
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }, 300)
        }
    }

    inner class ProxyClick {
        fun toMain() {
            MmkvUtils.putBoolean("first", false)
            startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
            finish()
            //带点渐变动画
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }

}