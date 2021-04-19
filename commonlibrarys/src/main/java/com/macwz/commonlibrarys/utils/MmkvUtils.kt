package com.macwz.commonlibrarys.utils

import android.os.Parcelable
import com.tencent.mmkv.MMKV
import java.util.*

object MmkvUtils {
    private val mmkv: MMKV? by lazy { MMKV.defaultMMKV() }

    fun putByteArray(key: String, value: ByteArray) {
        mmkv?.encode(key, value)
    }

    fun getByteArray(key: String) = mmkv?.decodeBytes(key)

    fun putDouble(key: String, value: Double) {
        mmkv?.encode(key, value)
    }

    fun getDouble(key: String) = mmkv?.decodeDouble(key, 0.00)?:0.00

    fun putLong(key: String, value: Long) {
        mmkv?.encode(key, value)
    }

    fun getLong(key: String) = mmkv?.decodeLong(key, 0L)?:0L

    fun putBoolean(key: String, value: Boolean) {
        mmkv?.encode(key, value)
    }

    fun getBoolean(key: String, defaultValue:Boolean) = mmkv?.decodeBool(key, defaultValue)?:defaultValue

    fun putInt(key: String, value: Int) {
        mmkv?.encode(key, value)
    }

    fun getInt(key: String) = mmkv?.decodeInt(key, 0)

    fun putString(key: String, value: String) {
        mmkv?.encode(key, value)
    }

    fun getString(key: String) = mmkv?.decodeString(key, "")

    fun putFloat(key: String, value: Float) {
        mmkv?.encode(key, value)
    }

    fun getFloat(key: String) = mmkv?.decodeFloat(key, 0F)

    fun <T : Parcelable> putParcelable(key: String, t: T?) {
        t?.let {
            mmkv?.encode(key, it)
        }
    }

    fun <T : Parcelable> getParcelable(key: String, tClass: Class<T>): T? =
        mmkv?.decodeParcelable(key, tClass)

    fun putStringSet(key: String, sets: Set<String>?) {
        sets?.let {
            mmkv?.encode(key, it)
        }
    }

    fun getStringSet(key: String): Set<String>? = mmkv?.decodeStringSet(key, Collections.emptySet())

    fun removeKey(key: String) {
        mmkv?.removeValueForKey(key)
    }

    fun clearAll() {
        mmkv?.clearAll()
    }
}