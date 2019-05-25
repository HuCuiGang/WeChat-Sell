package com.hcg.sell.service.impl;

import com.hcg.sell.dataObject.SellerInfo;
import com.hcg.sell.repository.SellerInfoRepository;
import com.hcg.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: sell
 * @description: 卖家Service实现
 * @author: hcg
 * @create: 2019-05-23 15:00
 * @modify by:
 * @updated:
 **/
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        SellerInfo sellerInfo = sellerInfoRepository.findByOpenid(openid);

        return sellerInfo;
    }
}
