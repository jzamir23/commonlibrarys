package com.macwz.module_home.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.macwz.common.router.ARouterUtils
import com.macwz.common.router.RouterPath
import com.macwz.common.router.provider.IWorkService
import com.macwz.module_home.R

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.home_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        view?.findViewById<TextView>(R.id.message)?.setOnClickListener {
            ARouterUtils.getComponentService<IWorkService>(RouterPath.WORK_SERVICE)?.toWork("")
        }
    }

}