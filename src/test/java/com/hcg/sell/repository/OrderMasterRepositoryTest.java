package com.hcg.sell.repository;

import com.hcg.sell.dataObject.OrderMaster;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerName("晓霞");
        orderMaster.setBuyerOpenid("1234567891");
        orderMaster.setBuyerAddress("春熙路18号");
        orderMaster.setBuyerPhone("15026616462");
        orderMaster.setOrderId("301");
        orderMaster.setOrderAmount(new BigDecimal(56.8));
        orderMasterRepository.save(orderMaster);
    }

    @Test
    public void findBybuyerOpenid(){
        Page<OrderMaster> orderMasters = orderMasterRepository.findBybuyerOpenid("1234567891", PageRequest.of(0, 3));
        orderMasters.getContent().forEach(System.out::println);
        Assert.assertNotEquals(0,orderMasters.getTotalElements());
    }
}