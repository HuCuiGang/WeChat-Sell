package com.hcg.sell.repository;

import com.hcg.sell.dataObject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sell
 * @description: 订单Repository接口
 * @author: hcg
 * @create: 2019-05-19 17:06
 * @modify by:
 * @updated:
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    Page<OrderMaster> findBybuyerOpenid(String buyerOpenid, Pageable pageable);
}
