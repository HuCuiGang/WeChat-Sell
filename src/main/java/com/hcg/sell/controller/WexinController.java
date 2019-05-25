package com.hcg.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: sell
 * @description: 微信接口手工方式
 * @author: hcg
 * @create: 2019-05-21 13:03
 * @modify by:
 * @updated:
 **/
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WexinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){
        log.info("进入auth方法。。。");
        log.info("code={}",code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxe78e6fb36cd3c8b1&secret=e66e051f39aa7c15728ceef44311db26&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url,String.class);
        log.info("response={}",response);

    }
}
