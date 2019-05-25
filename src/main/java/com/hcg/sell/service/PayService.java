package com.hcg.sell.service;

import com.hcg.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @program: sell
 * @description:
 * @author: hcg
 * @create: 2019-05-22 10:09
 * @modify by:
 * @updated:
 **/
public interface PayService {
    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
