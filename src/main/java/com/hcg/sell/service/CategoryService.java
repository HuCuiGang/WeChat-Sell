package com.hcg.sell.service;

import com.hcg.sell.dataObject.ProductCategory;

import java.util.List;

/**
 * @program: sell
 * @description: 商品类目service接口
 * @author: hcg
 * @create: 2019-05-17 19:03
 * @modify by:
 * @updated:
 **/
public interface CategoryService {
    ProductCategory findById(Integer id);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> ids);
    ProductCategory save(ProductCategory productCategory);
}
