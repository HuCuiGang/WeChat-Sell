package com.hcg.sell.utils;


import com.hcg.sell.eunms.CodeEnum;

/**
 * @program: sell
 * @description: 枚举工具类
 * @author: hcg
 * @create: 2019-05-18 14:14
 * @modify by:
 * @updated:
 **/
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
