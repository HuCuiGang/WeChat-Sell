package com.hcg.sell.service.impl;

import com.hcg.sell.dto.OrderDTO;
import com.hcg.sell.enums.ResultEnum;
import com.hcg.sell.exception.SellException;
import com.hcg.sell.service.BuyerService;
import com.hcg.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: sell
 * @description: 买家Service 实现
 * @author: hcg
 * @create: 2019-05-20 21:06
 * @modify by:
 * @updated:
 **/
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService{
    @Autowired
    private OrderService orderService;


    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO==null){
            log.error("【查询订单】查不到该订单,orderid={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderDTO;
    }
    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findByOrderId(orderId);
        if(orderDTO==null){
            return null;
        }
        //判断是否是自己的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】订单的openid不一致,openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROP);
        }
        return orderDTO;
    }

    @Override
    public OrderDTO canselOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO==null){
            log.error("【查询订单】查不到该订单,orderid={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }
}
