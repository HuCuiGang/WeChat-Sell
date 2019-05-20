package com.hcg.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hcg.sell.dataObject.OrderDetail;
import com.hcg.sell.dto.OrderDTO;
import com.hcg.sell.eunms.ResultEunm;
import com.hcg.sell.exception.SellException;
import com.hcg.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: sell
 * @description: 创建订单的参数OrderForm转换成OrderDTO
 * @author: hcg
 * @create: 2019-05-20 16:52
 * @modify by:
 * @updated:
 **/
@Slf4j
public class OrderFrom2OrderDTOConverter {

    public  static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        try{
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【对象转换错误】错误,string={}",orderForm.getItems());
            throw new SellException(ResultEunm.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

}
