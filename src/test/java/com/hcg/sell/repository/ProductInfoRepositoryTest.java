package com.hcg.sell.repository;

import com.hcg.sell.dataObject.ProductInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("203");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(20.0));
        productInfo.setProductStock(10);
        productInfo.setProductIcon("http://xxxxxxx.jpg");
        productInfo.setCategoryType(3);
        productInfo.setProductDescription("非常好吃的皮皮虾");
        productInfo.setProductStatus(0);
        productInfoRepository.save(productInfo);
    }
    @Test
    public void update(){
        ProductInfo productInfo = productInfoRepository.findById("201").get();
        productInfo.setCategoryType(1);
        productInfoRepository.save(productInfo);
    }

    @Test
    public void findByProductStatusTest(){
        List<ProductInfo> byProductStatus = productInfoRepository.findByProductStatus(0);
        byProductStatus.forEach(System.out::println);
    }


}