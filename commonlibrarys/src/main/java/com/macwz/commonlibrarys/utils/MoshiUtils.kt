package com.macwz.commonlibrarys.utils

import com.macwz.commonlibrarys.utils.adapter.DateAdapter
import com.macwz.commonlibrarys.utils.adapter.DateAdapter01
import com.macwz.commonlibrarys.utils.adapter.DateAdapter02
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okio.BufferedSource
import java.lang.reflect.Type

object MoshiUtils {
    val moshiBuild: Moshi by lazy {
        Moshi.Builder().add(DateAdapter()).add(DateAdapter01()).add(DateAdapter02())
            .add(KotlinJsonAdapterFactory()).build()
    }

    fun <T> getAdapter(type: Type): JsonAdapter<T> = moshiBuild.adapter(type)

    inline fun <reified T> getAdapter(): JsonAdapter<T> = moshiBuild.adapter(T::class.java)

    inline fun <reified T> toJson(t: T): String {
        return getAdapter<T>().toJson(t)
    }

    inline fun <reified T> fromJson(string: String): T? {
        return getAdapter<T>().fromJson(string)
    }

    inline fun <reified T> fromJson(source: BufferedSource): T? {
        return getAdapter<T>().fromJson(source)
    }

    inline fun <reified T> fromJsonList(json: String): List<T>? {
        return getAdapter<List<T>>(
            Types.newParameterizedType(
                List::class.java,
                T::class.java
            )
        ).fromJson(json)
    }

    inline fun <reified K, reified V> fromJsonMap(json: String): MutableMap<K, V>? {
        return getAdapter<MutableMap<K, V>>(
            Types.newParameterizedType(
                MutableMap::class.java,
                K::class.java,
                V::class.java
            )
        ).fromJson(json)
    }

}