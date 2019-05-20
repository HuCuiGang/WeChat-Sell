package com.hcg.sell.eunms;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: sell
 * @description: 异常信息返回给前端
 * @author: hcg
 * @create: 2019-05-19 21:00
 * @modify by:
 * @updated:
 **/
@Getter
public enum ResultEunm {
    PARAM_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不正确"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    ORDER_UPDATE_FAIL(15,"取消订单失败"),
    ORDER_DETAIL_EMPTY(16,"订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17,"订单支付状态不正确"),
    CART_EMPTY(18,"购物车不能为空"),
    ORDER_OWNER_ERROP(19,"该订单不属于当前用户"),
    PRODUCTCATEGORY_NOT_EXIST(30,"商品类目不存在"),
    ;
    private Integer code;
    private String message;

    ResultEunm(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
