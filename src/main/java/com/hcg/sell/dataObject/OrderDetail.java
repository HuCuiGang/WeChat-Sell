package com.hcg.sell.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @program: sell
 * @description: 订单详情
 * @author: hcg
 * @create: 2019-05-17 16:25
 * @Modify By:
 * @updated:
 **/
@Entity
@Data
public class OrderDetail {
    /** 订单详情. */
    @Id
    private String detailId;

    /** 订单id. */
    private String orderId;

    /** 商品id. */
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 商品单价. */
    private BigDecimal productPrice;

    /** 商品数量. */
    private Integer productQuantity;

    /** 商品小图. */
    private String productIcon;
}
