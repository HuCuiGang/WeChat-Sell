package com.hcg.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: sell
 * @description: 微信接口参数配置
 * @author: hcg
 * @create: 2019-05-21 15:21
 * @modify by:
 * @updated:
 **/
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    /**
     * 公众平台AppId
     */
    private String mpAppId;
    /**
     * 公众平台AppSecret
     */
    private String mpAppSecret;
    /**
     * 开放平台AppId
     */
    private String openAppId;
    /**
     * 开放平台AppSecret
     */
    private String openAppSecret;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * 商户秘钥
     */
    private String mchKey;
    /**
     * 商户证书途径
     */
    private String keyPath;
    /**
     * 异步通知地址
     */
    private String notifyUrl;

    /**
     * 微信模版id
     */
    private Map<String, String> templateId;

}
