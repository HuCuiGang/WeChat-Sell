package com.hcg.sell.eunms;

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
public enum ProductStatusEunm {

    UP(0,"上架"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private String msg;

    ProductStatusEunm(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
