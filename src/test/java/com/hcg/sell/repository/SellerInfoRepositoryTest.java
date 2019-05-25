package com.hcg.sell.repository;

import com.hcg.sell.dataObject.SellerInfo;
import com.hcg.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class SellerInfoRepositoryTest {
    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.getUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");
        SellerInfo save = sellerInfoRepository.save(sellerInfo);
        Assert.assertNotNull(save);
    }
    @Test
    public void findByOpenid(){
        SellerInfo sellerInfo = sellerInfoRepository.findByOpenid("abc");
        Assert.assertEquals("abc",sellerInfo.getOpenid());
    }
}