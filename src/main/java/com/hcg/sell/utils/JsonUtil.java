package com.hcg.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @program: sell
 * @description: json转换工具
 * @author: hcg
 * @create: 2019-05-22 13:29
 * @modify by:
 * @updated:
 **/
public class JsonUtil {
    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
