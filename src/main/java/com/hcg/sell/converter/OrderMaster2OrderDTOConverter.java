package com.hcg.sell.converter;

import com.hcg.sell.dataObject.OrderMaster;
import com.hcg.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: sell
 * @description: 前端OrderDTO与OrderMaster转换器
 * @author: hcg
 * @create: 2019-05-20 12:55
 * @modify by:
 * @updated:
 **/
public class OrderMaster2OrderDTOConverter {

    /**
    * @Description:  OrderMaster转OrderDTO
    * @Param: [orderMaster]
    * @return: com.hcg.sell.dto.OrderDTO
    * @Author: hcg
    * @CreateTime: 19-5-20 下午12:58
    * @Modify by:
    * @updated:
    */
    public static OrderDTO converter(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    /**
    * @Description:  OrderMasterList转OrderDTOList
    * @Param: [orderMasterList]
    * @return: java.util.List<com.hcg.sell.dto.OrderDTO>
    * @Author: hcg
    * @CreateTime: 19-5-20 下午1:02
    * @Modify by:
    * @updated:
    */
    public static List<OrderDTO> converter(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e ->
                converter(e)
        ).collect(Collectors.toList());
    }
}
