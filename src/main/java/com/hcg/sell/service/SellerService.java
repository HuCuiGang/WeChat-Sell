package com.hcg.sell.service;

import com.hcg.sell.dataObject.SellerInfo;

/**
 * @program: sell
 * @description: 卖家Service接口
 * @author: hcg
 * @create: 2019-05-23 14:58
 * @modify by:
 * @updated:
 **/
public interface SellerService {
    SellerInfo findSellerInfoByOpenid(String openid);
}
