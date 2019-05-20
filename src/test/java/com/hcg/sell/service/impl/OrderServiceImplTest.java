package com.hcg.sell.service.impl;

import com.hcg.sell.dataObject.OrderDetail;
import com.hcg.sell.dto.CartDTO;
import com.hcg.sell.dto.OrderDTO;
import com.hcg.sell.eunms.OrderStatusEnum;
import com.hcg.sell.eunms.PayStatusEnum;
import com.hcg.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;
    /** 买家微信 */
    private final String BUYER_OPENID = "1234567892";
    private final String ORDER_ID = "1558332345188139736";

    @Test

    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("晓霞");
        orderDTO.setBuyerAddress("吹西路12号");
        orderDTO.setBuyerPhone("15026616462");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        /** 添加购物车中的商品信息 */
        ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("202");
        orderDetail.setProductQuantity(3);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("201");
        orderDetail2.setProductQuantity(1);

        orderDetails.add(orderDetail);
        orderDetails.add(orderDetail2);

        orderDTO.setOrderDetailList(orderDetails);

        OrderDTO result = orderService.create(orderDTO);
        log.info("创建订单：result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        OrderDTO result = orderService.findByOrderId(ORDER_ID);
        log.info("【根据订单id查询单个订单】result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findList() {
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, PageRequest.of(0, 3));
        log.info("【根据微信查询多个订单】result={}",orderDTOPage.getContent());
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findByOrderId(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findByOrderId(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findByOrderId(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }
}