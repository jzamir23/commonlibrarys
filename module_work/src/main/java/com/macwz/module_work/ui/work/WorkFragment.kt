package com.macwz.module_work.ui.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.macwz.common.router.RouterPath
import com.macwz.common.router.provider.IHomeService
import com.macwz.common.router.ARouterUtils
import com.macwz.common.router.provider.IMyService
import com.macwz.module_work.R

class WorkFragment : Fragment() {

    companion object {
        fun newInstance() = WorkFragment()
    }

    private lateinit var viewModel: WorkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.work_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(WorkViewModel::class.java)
        view?.findViewById<TextView>(R.id.message)?.setOnClickListener {
            ARouterUtils.getComponentService<IMyService>(RouterPath.MY_SERVICE)?.toMy("")

        }
    }

}