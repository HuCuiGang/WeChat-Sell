package com.hcg.sell.repository;

import com.hcg.sell.dataObject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: sell
 * @description: 订单详情Repository接口
 * @author: hcg
 * @create: 2019-05-19 19:49
 * @modify by:
 * @updated:
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
     List<OrderDetail> findByOrderId(String orderId);
}
