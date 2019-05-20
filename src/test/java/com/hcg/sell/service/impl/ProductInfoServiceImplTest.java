package com.hcg.sell.service.impl;

import com.hcg.sell.dataObject.ProductInfo;
import com.hcg.sell.eunms.ProductStatusEunm;
import com.hcg.sell.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoService productInfoService;
    @Test
    public void findById() {
        ProductInfo productInfo = productInfoService.findById("202");
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void findAll() {
        List<ProductInfo> productInfos = productInfoService.findAll();
        Assert.assertNotEquals(0,productInfos.size());
    }

    @Test
    public void findPageAll() {
        //PageRequest pageRequest = new PageRequest(0,3); 过时的方法
        Page<ProductInfo> infoPage = productInfoService.findPageAll(PageRequest.of(0,3));
        Assert.assertNotEquals(0,infoPage.getTotalElements());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfos = productInfoService.findUpAll();
        Assert.assertNotEquals(0,productInfos.size());
    }

    @Test
    public void findDownAll() {
        List<ProductInfo> productInfos = productInfoService.findDownAll();
        Assert.assertNotEquals(0,productInfos.size());
    }

    @Test

    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("204");
        productInfo.setProductName("蛋炒饭");
        productInfo.setProductPrice(new BigDecimal(10.0));
        productInfo.setProductStock(20);
        productInfo.setProductIcon("http://xxxxxxx.jpg");
        productInfo.setCategoryType(1);
        productInfo.setProductDescription("非常好吃的蛋炒饭");
        productInfo.setProductStatus(ProductStatusEunm.DOWN.getCode());
        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void update() {
        ProductInfo productInfo = productInfoService.findById("202");
        productInfo.setProductStatus(ProductStatusEunm.UP.getCode());
        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }
}