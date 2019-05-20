package com.hcg.sell.repository;

import com.hcg.sell.dataObject.ProductCategory;
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
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> list);
    ProductCategory findByCategoryId(Integer id);
}
