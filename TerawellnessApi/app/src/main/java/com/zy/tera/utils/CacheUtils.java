package com.zy.tera.utils;

import android.content.Context;

/**
 * Created by yz250242 on 2018/3/28.
 */

public class CacheUtils {

    private static ACache cache;

    public static ACache getInstance(Context context){
        if (null==cache){
            cache = ACache.get(context.getApplicationContext());
        }

        return cache;
    }
}
