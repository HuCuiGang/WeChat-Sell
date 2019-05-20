package com.hcg.sell.repository;

import com.hcg.sell.dataObject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: sell
 * @description: 商品信息Repository借口
 * @author: hcg
 * @create: 2019-05-18 14:23
 * @modify by:
 * @updated:
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    //根剧商品状态查商品
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
