package com.hcg.sell.enums;

import lombok.Getter;

/**
 * @program: sell
 *
 * @description: 商品状态
 *
 * @author: hcg
 *
 * @create: 2019-05-18 18:16
 *
 * @modify by:
 *
 * @updated:
 **/
@Getter
public enum ProductStatusEnum implements CodeEnum {

    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
