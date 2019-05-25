package com.hcg.sell.controller;

import com.hcg.sell.dataObject.ProductCategory;
import com.hcg.sell.dataObject.ProductInfo;
import com.hcg.sell.exception.SellException;
import com.hcg.sell.form.ProductForm;
import com.hcg.sell.service.CategoryService;
import com.hcg.sell.service.ProductInfoService;
import com.hcg.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @program: sell
 * @description: 卖家端商品API
 * @author: hcg
 * @create: 2019-05-22 20:26
 * @modify by:
 * @updated:
 **/
@Controller
@Slf4j
@RequestMapping("/seller/product")
public class SellerProductController {
    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    /**
    * @Description: 商品列表
    * @Param: []
    * @return: org.springframework.web.servlet.ModelAndView
    * @Author: hcg
    * @CreateTime: 19-5-22 下午8:30
    * @Modify by:
    * @updated:
    */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map){
        Page<ProductInfo> productInfoPage = productInfoService.findPageAll(PageRequest.of(page - 1, size));
        map.put("productInfoPage",productInfoPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("/product/list",map);
    }
    /** 
    * @Description: 上架 
    * @Param: [porductId, map] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: hcg 
    * @CreateTime: 19-5-23 下午12:17
    * @Modify by:
    * @updated:
    */
    @GetMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String porductId,
                               Map<String,Object> map){

        try{
            productInfoService.onSale(porductId);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","list");
            return new ModelAndView("common/error",map);
        }
        map.put("url","list");
        return new ModelAndView("common/success",map);
    }
    /** 
    * @Description: 下架 
    * @Param: [porductId, map] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: hcg 
    * @CreateTime: 19-5-23 下午12:18
    * @Modify by:
    * @updated:
    */
    @GetMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String porductId,
                               Map<String,Object> map){

        try{
            productInfoService.offSale(porductId);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","list");
            return new ModelAndView("common/error",map);
        }

        map.put("url","list");

        return new ModelAndView("common/success",map);
    }
    
    /** 
    * @Description: 修改页面 
    * @Param: [productId, map] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: hcg 
    * @CreateTime: 19-5-23 下午12:18
    * @Modify by:
    * @updated:
    */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false) String productId,
                              Map<String,Object> map){
        if(!StringUtils.isEmpty(productId)){
            ProductInfo productInfo = productInfoService.findById(productId);
            map.put("productInfo",productInfo);
        }

        //查询所有类目
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("/product/index",map);
    }
    
    /** 
    * @Description: 保存/更新
    * @Param: [from, bindingResult] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: hcg 
    * @CreateTime: 19-5-23 下午12:20
    * @Modify by:
    * @updated:
    */
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm from,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","index");
            return new ModelAndView("common/error",map);
        }

        ProductInfo productInfo = new ProductInfo();

        try{
            //如果productId不为空，说明是修改
            if(!StringUtils.isEmpty(from.getProductId())){
                productInfo = productInfoService.findById(from.getProductId());
            }else {
                from.setProductId(KeyUtil.getUniqueKey());
            }
            BeanUtils.copyProperties(from,productInfo);
            productInfoService.save(productInfo);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","index");
            return new ModelAndView("/common/error",map);
        }

        map.put("url","list");
        return new ModelAndView("/common/success",map);


    }
}
