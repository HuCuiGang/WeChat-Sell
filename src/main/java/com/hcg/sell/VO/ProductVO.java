package com.hcg.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: sell
 * @description: 商品（包含类目）
 * @author: hcg
 * @create: 2019-05-18 19:30
 * @modify by:
 * @updated:
 **/
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVoList;
}
