package com.hcg.sell.service;

import com.hcg.sell.dataObject.OrderMaster;
import com.hcg.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @program: sell
 * @description: 订单Service接口
 * @author: hcg
 * @create: 2019-05-19 20:33
 * @modify by:
 * @updated:
 **/
public interface OrderService {
    /** 创建订单. */
    OrderDTO create(OrderDTO orderDTO);
    /** 根据订单id查询单个订单. */
    OrderDTO findByOrderId(String orderId);
    /** 根据微信查询订单列表. */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);
    /** 取消订单. */
    OrderDTO cancel(OrderDTO orderDTO);
    /** 完结订单. */
    OrderDTO finish(OrderDTO orderDTO);
    /** 支付订单. */
    OrderDTO paid(OrderDTO orderDTO);
    /** 查询所有订单列表. */
    Page<OrderDTO> findList(Pageable pageable);
}
