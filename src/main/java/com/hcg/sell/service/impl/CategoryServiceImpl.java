package com.hcg.sell.service.impl;

import com.hcg.sell.dataObject.ProductCategory;
import com.hcg.sell.eunms.ResultEunm;
import com.hcg.sell.exception.SellException;
import com.hcg.sell.repository.ProductCategoryRepository;
import com.hcg.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @program: sell
 * @description: 商品类目service实现
 * @author: hcg
 * @create: 2019-05-17 19:13
 * @modify by:
 * @updated:
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findById(Integer id) {
        Optional<ProductCategory> optionalProductCategory = productCategoryRepository.findById(id);
        if (!optionalProductCategory.isPresent()){
            throw new SellException(ResultEunm.PRODUCTCATEGORY_NOT_EXIST);
        }
        return optionalProductCategory.get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> ids) {
        return productCategoryRepository.findByCategoryTypeIn(ids);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
