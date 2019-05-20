package com.hcg.sell.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @program: sell
 * @description: 商品信息
 * @author: hcg
 * @create: 2019-05-18 14:14
 * @modify by:
 * @updated:
 **/
@Entity
@DynamicUpdate
@Data
public class ProductInfo {
    //商品ID
    @Id
    private String productId;
    //商品名称
    private String productName;
    //单价
    private BigDecimal productPrice;
    //库存
    private Integer productStock;
    //描述
    private String productDescription;
    //小图
    private String productIcon;
    //状态(0 正常,1下架)
    private Integer productStatus;
    //类目编号
    private Integer categoryType;

}