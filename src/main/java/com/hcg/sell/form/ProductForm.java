package com.hcg.sell.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @program: sell
 * @description: 商品表达提交的字段
 * @author: hcg
 * @create: 2019-05-23 12:13
 * @modify by:
 * @updated:
 **/
@Data
public class ProductForm {
    //商品ID
    private String productId;
    //商品名称
    @NotNull(message = "商品名称必填")
    private String productName;
    //单价
    @NotNull(message = "商品单价必填")
    private BigDecimal productPrice;
    //库存
    @NotNull(message = "商品库存必填")
    private Integer productStock;
    //描述
    private String productDescription;
    //小图
    private String productIcon;
    //类目编号
    @NotNull(message = "商品类目编号必填")
    private Integer categoryType;
}
