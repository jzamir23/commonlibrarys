package com.macwz.commonlibrarys.utils.adapter;

import com.blankj.utilcode.util.LogUtils;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import java.util.Date;

/**
 * 对Date类型进行解析
 */
public class DateAdapter01 {

    @ToJson
    String toJson(Date date) {
        if (date == null) {
            LogUtils.e("date is null");
            return "";
        }
        return DateFormatter.format(date, "yyyy-MM-dd HH:mm:ss");
    }

    @FromJson
    Date fromJson(String date) {
        if (date != null) {
            return DateFormatter.parse(date, "yyyy-MM-dd HH:mm:ss");
        }
        return null;
    }


}