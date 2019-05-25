package com.hcg.sell.service.impl;

import com.hcg.sell.dataObject.ProductCategory;
import com.hcg.sell.service.CategoryService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findById() {
        ProductCategory one = categoryService.findById(1);
        Assert.assertEquals(new Integer(1),one.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> all = categoryService.findAll();
        Assert.assertNotEquals(0,all.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> byCategoryTypeIn = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2));
        Assert.assertNotEquals(0,byCategoryTypeIn.size());
    }

    @Test
    @Transactional //无论如何都要回滚--测试专用
    public void save() {
        ProductCategory productCategory = new ProductCategory("男生最爱",3);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
    @Test
    @Transactional
    public void update() {
        ProductCategory productCategory = categoryService.findById(1);
        productCategory.setCategoryName("热卖商品");
        productCategory.setCategoryType(1);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }

}