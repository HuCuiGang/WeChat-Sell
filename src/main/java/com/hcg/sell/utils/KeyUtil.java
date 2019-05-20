package com.hcg.sell.utils;

import java.util.Random;

/**
 * @program: sell
 * @description:
 * @author: hcg
 * @create: 2019-05-19 21:22
 * @modify by:
 * @updated:
 **/
public class KeyUtil {

    /** 
    * @Description: 生产唯一主键 格式：时间戳+随机数
    * @Param: [] 
    * @return: java.lang.String 
    * @Author: hcg 
    * @CreateTime: 19-5-19 下午9:25
    * @Modify by:
    * @updated:
    */
    public static String getUniqueKey(){
        Random random = new Random();
        /** 生成6位的随机数 */
        Integer number = random.nextInt(90000)+100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
