package com.hcg.sell.utils;

import com.hcg.sell.constant.RedisConstant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: sell
 * @description: Cookie工具类
 * @author: hcg
 * @create: 2019-05-23 18:27
 * @modify by:
 * @updated:
 **/
public class CookieUtil {
    /** 
    * @Description: 设置cookie
    * @Param: [response, name, value, maxAge] 
    * @return: void 
    * @Author: hcg 
    * @CreateTime: 19-5-23 下午6:31
    * @Modify by:
    * @updated:
    */
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }
    /** 
    * @Description: 获取cookie 
    * @Param: [request, name] 
    * @return: javax.servlet.http.Cookie 
    * @Author: hcg 
    * @CreateTime: 19-5-24 下午2:39
    * @Modify by:
    * @updated:
    */
    public static Cookie get(HttpServletRequest request,
                           String name){
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }else {
            return null;
        }

    }
    /** 
    * @Description: 讲cookie封装成map
    * @Param: [request] 
    * @return: java.util.Map<java.lang.String,javax.servlet.http.Cookie> 
    * @Author: hcg 
    * @CreateTime: 19-5-24 下午3:01
    * @Modify by:
    * @updated:
    */
    private static Map<String,Cookie> readCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMapmap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie: cookies){
                cookieMapmap.put(cookie.getName(),cookie);
            }
        }
        return cookieMapmap;
    }
}
