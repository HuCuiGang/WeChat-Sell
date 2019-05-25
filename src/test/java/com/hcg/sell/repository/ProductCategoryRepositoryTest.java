package com.hcg.sell.repository;

import com.hcg.sell.dataObject.ProductCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public  void saveTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(3);
        productCategoryRepository.save(productCategory);
    }
    @Test
    public  void updateTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryName("热卖商sad");
        productCategory.setCategoryType(1);
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void findById(){

        ProductCategory productCategory = productCategoryRepository.findById(1).get();
        System.out.println(productCategory);
    }
    @Test
    public void findAll(){
        List<ProductCategory> list = productCategoryRepository.findAll();
        list.forEach(System.out::println);
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(1,2);
        List<ProductCategory> byCategoryTypeIn = productCategoryRepository.findByCategoryTypeIn(list);
        byCategoryTypeIn.forEach(System.out::println);
    }

}