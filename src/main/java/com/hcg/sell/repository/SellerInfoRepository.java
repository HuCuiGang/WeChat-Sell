package com.hcg.sell.repository;

import com.hcg.sell.dataObject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sell
 * @description: 卖家Repository
 * @author: hcg
 * @create: 2019-05-23 14:36
 * @modify by:
 * @updated:
 **/
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {
    SellerInfo findByOpenid(String openid);
}
