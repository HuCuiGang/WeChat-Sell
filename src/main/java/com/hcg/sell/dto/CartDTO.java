package com.hcg.sell.dto;

import lombok.Data;

/**
 * @program: sell
 *
 * @description: 购物车
 *
 * @author: hcg
 *
 * @create: 2019-05-18 18:16
 *
 * @modify by:
 *
 * @updated:
 **/
@Data
public class CartDTO {

    /** 商品Id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
