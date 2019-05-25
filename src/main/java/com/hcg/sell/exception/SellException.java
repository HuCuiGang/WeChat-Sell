package com.hcg.sell.exception;

import com.hcg.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @program: sell
 * @description: 自定义异常
 * @author: hcg
 * @create: 2019-05-19 20:55
 * @modify by:
 * @updated:
 **/
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
