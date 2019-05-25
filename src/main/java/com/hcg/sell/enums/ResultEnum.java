package com.hcg.sell.enums;

import lombok.Getter;

/**
 * @program: sell
 * @description: 异常信息返回给前端
 * @author: hcg
 * @create: 2019-05-19 21:00
 * @modify by:
 * @updated:
 **/
@Getter
public enum ResultEnum {
    SUCCESS(0,"成功"),
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
    WX_MP_ERROR(20,"微信公众账号方面错误"),
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21,"微信支付异步通知金额校验不通过"),
    ORDER_CANCEL_SUCCESS(22,"取消订单成功"),
    ORDER_FINISH_SUCCESS(23,"完结订单成功"),
    PRODUCT_STATUS_ERROR(24,"商品状态不正确"),
    LOGIN_FAIL(25,"登录失败,登录信息不正确"),
    LOGIN_OUT_SUCCESS(26,"注销登录成功"),
    PRODUCTCATEGORY_NOT_EXIST(30,"商品类目不存在"),


    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
