package com.hcg.sell.eunms;

import lombok.Getter;

/**
 * @program: sell
 *
 * @description: 支付状态
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
public enum PayStatusEnum implements CodeEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),

    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
