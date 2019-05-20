package com.hcg.sell.service;

import com.hcg.sell.dataObject.ProductInfo;
import com.hcg.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @program: sell
 * @description: 商品信息service接口
 * @author: hcg
 * @create: 2019-05-18 17:14
 * @modify by:
 * @updated:
 **/
public interface ProductInfoService {
    ProductInfo findById(String id);
    List<ProductInfo> findAll();
    /** 
    * @Description: 查询所有商品带分页 
    * @Param: [pageable] 
    * @return: org.springframework.data.domain.Page<com.hcg.sell.dataObject.ProductInfo> 
    * @Author: hcg 
    * @CreateTime: 19-5-18 下午6:53
    * @Modify by:
    * @updated:
    */
    Page<ProductInfo> findPageAll(Pageable pageable);
    /** 
    * @Description: 查询所有上架商品 
    * @Param: [] 
    * @return: java.util.List<com.hcg.sell.dataObject.ProductInfo> 
    * @Author: hcg 
    * @CreateTime: 19-5-18 下午6:11
    * @Modify by:
    * @updated:
    */
    List<ProductInfo> findUpAll();
    List<ProductInfo> findDownAll();
    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);
    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
