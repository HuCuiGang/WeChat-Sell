package com.hcg.sell.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @program: sell
 * @description: 卖家信息
 * @author: hcg
 * @create: 2019-05-18 14:14
 * @modify by:
 * @updated:
 **/
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
