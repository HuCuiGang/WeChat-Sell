package com.hcg.sell.repository;

import com.hcg.sell.dataObject.OrderDetail;
import org.junit.Assert;
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
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("402");
        orderDetail.setOrderId("301");
        orderDetail.setProductIcon("http://xxxxxxx.jpeg");
        orderDetail.setProductId("203");
        orderDetail.setProductName("皮皮虾");
        orderDetail.setProductPrice(new BigDecimal(20));
        orderDetail.setProductQuantity(1);
        OrderDetail orderDetails = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(orderDetails);
    }

    @Test
    public void findByOrderId(){
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId("301");
        orderDetailList.forEach(System.out::println);
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}