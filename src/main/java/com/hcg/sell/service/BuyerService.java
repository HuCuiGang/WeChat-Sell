package com.hcg.sell.service;

import com.hcg.sell.dto.OrderDTO;

/**
 * @program: sell
 * @description: 买家Service接口
 * @author: hcg
 * @create: 2019-05-20 21:03
 * @modify by:
 * @updated:
 **/
public interface BuyerService {
    //查询一个买家的订单
    OrderDTO findOrderOne(String openid,String orderid);

    //取消订单
    OrderDTO canselOrder(String openid,String orderid );
}
