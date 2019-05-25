package com.hcg.sell.controller;

import com.hcg.sell.dto.OrderDTO;
import com.hcg.sell.enums.ResultEnum;
import com.hcg.sell.exception.SellException;
import com.hcg.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @program: sell
 * @description: 卖家端订单
 * @author: hcg
 * @create: 2019-05-22 15:10
 * @modify by:
 * @updated:
 **/
@Controller
@RequestMapping("/seller/order")
@Slf4j()
public class SellerOrderContrlloer {

    @Autowired
    private OrderService orderService;
    /** 
    * @Description: 订单列表
    * @Param: [page 第几页, size 一页显示多少条数据]
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: hcg 
    * @CreateTime: 19-5-22 下午3:14
    * @Modify by:
    * @updated:
    */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map){
        Page<OrderDTO> orderDTOPage = orderService.findList(PageRequest.of(page - 1, size));
        map.put("orderDTOPage",orderDTOPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("order/list",map);
    }
    /** 
    * @Description: 取消订单
    * @Param: [orderId]
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: hcg 
    * @CreateTime: 19-5-22 下午5:58
    * @Modify by:
    * @updated:
    */
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               Map<String,Object> map){
        OrderDTO orderDTO;
        try {
            orderDTO = orderService.findByOrderId(orderId);
            orderService.cancel(orderDTO);
        }catch (SellException e){
            log.error("【卖家端取消订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }
    /** 
    * @Description: 订单详情 
    * @Param: [orderId, map] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: hcg 
    * @CreateTime: 19-5-22 下午6:47
    * @Modify by:
    * @updated:
    */

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String,Object> map){
        OrderDTO orderDTO;
        try {
            orderDTO = orderService.findByOrderId(orderId);
        }catch (SellException e){
            log.error("【卖家端取消订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("orderDTO",orderDTO);

        return new ModelAndView("order/detail",map);
    }

    /** 
    * @Description: 完结订单
    * @Param: [orderId, map] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: hcg 
    * @CreateTime: 19-5-22 下午7:19
    * @Modify by:
    * @updated:
    */
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String,Object> map){
        OrderDTO orderDTO;
        try {
            orderDTO = orderService.findByOrderId(orderId);
            orderService.finish(orderDTO);
        }catch (SellException e){
            log.error("【卖家端完结订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }


}
