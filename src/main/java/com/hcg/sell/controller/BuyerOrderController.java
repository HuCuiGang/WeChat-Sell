package com.hcg.sell.controller;

import com.hcg.sell.VO.ResultVO;
import com.hcg.sell.converter.OrderFrom2OrderDTOConverter;
import com.hcg.sell.dto.OrderDTO;
import com.hcg.sell.eunms.ResultEunm;
import com.hcg.sell.exception.SellException;
import com.hcg.sell.form.OrderForm;
import com.hcg.sell.service.BuyerService;
import com.hcg.sell.service.OrderService;
import com.hcg.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hcg.sell.eunms.ResultEunm.*;

/**
 * @program: sell
 * @description: 订单PAI
 * @author: hcg
 * @create: 2019-05-20 16:26
 * @modify by:
 * @updated:
 **/
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确,orderForm={}", orderForm);
            throw new SellException(PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderFrom2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<String, String>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEunm.PARAM_ERROR.getCode(), "openid为空");
        }
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, PageRequest.of(page, size));

        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    //查询订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderid") String orderid) {

        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单详情】openid为空");
            throw new SellException(ResultEunm.PARAM_ERROR.getCode(), "openid不能为空");
        }
        if (StringUtils.isEmpty(orderid)) {
            log.error("【查询订单详情】orderid");
            throw new SellException(ResultEunm.PARAM_ERROR.getCode(), "orderid不能为空");
        }
        //不安全的做法,需改进
        /*OrderDTO orderDTO = orderService.findByOrderId(orderid);*/
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderid);

        return ResultVOUtil.success(orderDTO);
    }

    //取消订单
    @PostMapping("/cansel")
    public ResultVO<OrderDTO> cansel(@RequestParam("openid") String openid,
                                     @RequestParam("orderid") String orderid) {
        //不安全改进
        /*OrderDTO orderDTO = orderService.findByOrderId(orderid);*/
        buyerService.canselOrder(openid, orderid);
        return ResultVOUtil.success();
    }


}
