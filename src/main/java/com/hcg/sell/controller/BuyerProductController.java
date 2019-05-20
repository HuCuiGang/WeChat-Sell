package com.hcg.sell.controller;

import com.hcg.sell.VO.ProductInfoVO;
import com.hcg.sell.VO.ProductVO;
import com.hcg.sell.VO.ResultVO;
import com.hcg.sell.dataObject.ProductCategory;
import com.hcg.sell.dataObject.ProductInfo;
import com.hcg.sell.service.CategoryService;
import com.hcg.sell.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcg.sell.utils.ResultVOUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: sell
 * @description: 商品API
 * @author: hcg
 * @create: 2019-05-18 19:15
 * @modify by:
 * @updated:
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public ResultVO List(){
        //1.查询所有上架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //2.查询类目（一次性查询）
        /*List<Integer> categoryTypeList = new ArrayList<Integer>();
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }*/
        //lambda表达式
        List<Integer> integerList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(integerList);
        //3.数据拼装
        List<ProductVO> productVoList = new ArrayList<ProductVO>();
        productCategoryList.forEach(productCategory -> {
            ProductVO productVo = new ProductVO();
            productVo.setCategoryType(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVoList = new ArrayList<ProductInfoVO>();
            productInfoList.forEach(productInfo -> {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVo = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            });

            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        });

        ResultVO resultVo = new ResultVO();
        resultVo.setData(productVoList);
        resultVo.setCode(0);
        resultVo.setMsg("成功");

        return ResultVOUtil.success(productVoList);
    }


}
