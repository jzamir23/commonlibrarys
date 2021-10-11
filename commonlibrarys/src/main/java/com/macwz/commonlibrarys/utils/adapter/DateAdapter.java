package com.macwz.commonlibrarys.utils.adapter;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import java.util.Date;

/**
 * 对Date类型进行解析
 */
public class DateAdapter {
    @ToJson
    String toJson(Date date) {
        if (date == null) {
            return "";
        }
        return DateFormatter.format(date, "yyyy-MM-dd");
    }

    @FromJson
    Date fromJson(String date) {
        if (date != null) {
            return DateFormatter.parse(date, "yyyy-MM-dd");
        }
        return null;
    }


}