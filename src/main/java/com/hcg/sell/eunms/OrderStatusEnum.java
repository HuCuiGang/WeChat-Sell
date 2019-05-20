package com.hcg.sell.eunms;

import lombok.Getter;

/**
 * @program: sell
 *
 * @description: 订单状态
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
public enum OrderStatusEnum implements CodeEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
