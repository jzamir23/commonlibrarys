package com.macwz.commonlibrarys.network.manager

import com.macwz.commonlibrarys.common.livedata.EventLiveData

class NetworkStateManager private constructor() {

    val mNetworkStateCallback = EventLiveData<NetState>()

    companion object {
        val instance: NetworkStateManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetworkStateManager()
        }
    }

}