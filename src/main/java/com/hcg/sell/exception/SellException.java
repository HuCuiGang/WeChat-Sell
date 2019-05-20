package com.hcg.sell.exception;

import com.hcg.sell.eunms.ResultEunm;
import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;

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

    public SellException(ResultEunm resultEunm) {
        super(resultEunm.getMessage());
        this.code = resultEunm.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
