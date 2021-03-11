package com.macwz.module_my.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.macwz.module_common.RoutePath
import com.macwz.module_common.componentbase.ComponentServiceUtil
import com.macwz.module_common.componentbase.IComponentService
import com.macwz.module_my.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.main_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        view?.findViewById<TextView>(R.id.message)?.setOnClickListener {

            ComponentServiceUtil.navigateHomePage("dds")

            Log.i("11111", "${ComponentServiceUtil.getParameterInfo(RoutePath.HOME_SERVICE)}")

        }
    }

}