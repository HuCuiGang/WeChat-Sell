package com.hcg.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;


/**
 * @program: sell
 * @description: 创建订单的参数
 * @author: hcg
 * @create: 2019-05-20 16:31
 * @modify by:
 * @updated:
 **/
@Data
public class OrderForm {
    /**
     * 买家姓名
     */
    @NotNull(message = "姓名必填")
    private String name;
    /**
     * 买家电话
     */
    @NotNull(message = "电话必填")
    private String phone;
    /**
     * 买家地址
     */
    @NotNull(message = "地址必填")
    private String address;
    /**
     * 买家微信openid
     */
    @NotNull(message = "openid必填")
    private String openid;
    /**
     * 购物车不能为空
     */
    @NotNull(message = "购物车不能为空")
    private String items;


}
