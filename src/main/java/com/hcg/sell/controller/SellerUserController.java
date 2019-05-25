package com.hcg.sell.controller;

import com.hcg.sell.config.ProjectUrlConfig;
import com.hcg.sell.constant.CookieConstant;
import com.hcg.sell.constant.RedisConstant;
import com.hcg.sell.dataObject.SellerInfo;
import com.hcg.sell.enums.ResultEnum;
import com.hcg.sell.service.SellerService;

import com.hcg.sell.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @program: sell
 * @description: 卖家端登录
 * @author: hcg
 * @create: 2019-05-23 17:51
 * @modify by:
 * @updated:
 **/
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              HttpServletResponse response,
                              Map<String,Object> map){

        //1.openid去和数据苦匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if(sellerInfo==null){
             map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
             map.put("url","/sell/seller/order/list");
             return new ModelAndView("common/error");

        }

        //2.设置token到redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openid,expire, TimeUnit.SECONDS);

        //3.设置token值cookie
        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);

        return new ModelAndView("redirect:"+projectUrlConfig.getSell()+"/sell/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String,Object> map){

        //1.从cookie查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        //2.清除redis
        if(cookie!=null){
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        }
        //3.清除cookie
        CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        map.put("msg",ResultEnum.LOGIN_OUT_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }
}
