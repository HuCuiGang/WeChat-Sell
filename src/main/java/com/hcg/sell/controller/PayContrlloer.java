package com.hcg.sell.controller;

import com.hcg.sell.dto.OrderDTO;
import com.hcg.sell.enums.ResultEnum;
import com.hcg.sell.exception.SellException;
import com.hcg.sell.service.OrderService;
import com.hcg.sell.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @program: sell
 * @description: 支付API、
 * @author: hcg
 * @create: 2019-05-22 10:08
 * @modify by:
 * @updated:
 **/
@Controller
@Slf4j
@RequestMapping("/pay")
public class PayContrlloer {
    @Autowired
    private OrderService orderService;
    @Autowired
    private PayService payService;

    @RequestMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String,Object> map){

        //1.查询订单
        OrderDTO orderDTO = orderService.findByOrderId(orderId);
        if (orderDTO==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //2.发起支付
        PayResponse payResponse = payService.create(orderDTO);
        map.put("payResponse",payResponse);
        map.put("returnUrl",returnUrl);

        return new ModelAndView("/pay/create",map);
    }
    /**
     * 微信异步通知
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        payService.notify(notifyData);

        //返回给微信处理结果
        return new ModelAndView("pay/success");
    }

}
