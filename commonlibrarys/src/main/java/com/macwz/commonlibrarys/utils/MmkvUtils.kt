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

    fun getDouble(key: String) = when (val v = mmkv?.decodeDouble(key, 0.00)) {
        null, 0.00 -> null
        else -> v
    }

    fun putLong(key: String, value: Long) {
        mmkv?.encode(key, value)
    }

    fun getLong(key: String) = when (val v = mmkv?.decodeLong(key, 0L)) {
        null, 0L -> null
        else -> v
    }

    fun putBoolean(key: String, value: Boolean) {
        mmkv?.encode(key, value)
    }

    fun getBoolean(key: String, defaultValue: Boolean) = mmkv?.decodeBool(key, defaultValue)

    fun putInt(key: String, value: Int) {
        mmkv?.encode(key, value)
    }

    fun getInt(key: String) = when (val v = mmkv?.decodeInt(key, 0)) {
        null, 0 -> null
        else -> v
    }

    fun putString(key: String, value: String) {
        mmkv?.encode(key, value)
    }

    fun getString(key: String) = when (val v = mmkv?.decodeString(key, "")) {
        null, "" -> null
        else -> v
    }

    fun putFloat(key: String, value: Float) {
        mmkv?.encode(key, value)
    }

    fun getFloat(key: String) = when (val v = mmkv?.decodeFloat(key, 0F)) {
        null, 0F -> null
        else -> v
    }

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

    fun getStringSet(key: String): Set<String>? =
        when (val v = mmkv?.decodeStringSet(key, Collections.emptySet())) {
            null, Collections.EMPTY_SET -> null
            else -> v
        }

    fun removeKey(key: String) {
        mmkv?.removeValueForKey(key)
    }

    fun clearAll() {
        mmkv?.clearAll()
    }
}