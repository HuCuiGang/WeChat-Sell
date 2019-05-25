package com.hcg.sell.controller;

import com.hcg.sell.dataObject.ProductCategory;
import com.hcg.sell.exception.SellException;
import com.hcg.sell.form.CategoryForm;
import com.hcg.sell.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * @description: 卖家类目
 * @author: hcg
 * @create: 2019-05-23 13:19
 * @modify by:
 * @updated:
 **/
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryContrller {

    @Autowired
    private CategoryService categoryService;
    
    /** 
    * @Description: 展示类目列表
    * @Param: [map] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: hcg 
    * @CreateTime: 19-5-23 下午1:24
    * @Modify by:
    * @updated:
    */
    @GetMapping("/list")
    public ModelAndView list(Map<String,Object>map){

        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("category/list",map);
    }
    
    /** 
    * @Description: 修改类目页面
    * @Param: [] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: hcg 
    * @CreateTime: 19-5-23 下午1:24
    * @Modify by:
    * @updated:
    */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                              Map<String,Object> map){
        if (categoryId !=null){
            ProductCategory productCategory = categoryService.findById(categoryId);
            map.put("category",productCategory);
        }
        return new ModelAndView("category/index",map);
    }
    /**
    * @Description: 保存/更新
    * @Param: [form, bindingResult, map]
    * @return: org.springframework.web.servlet.ModelAndView
    * @Author: hcg
    * @CreateTime: 19-5-23 下午1:48
    * @Modify by:
    * @updated:
    */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map) {

        if (bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","index");
            return new ModelAndView("common/error",map);
        }
        ProductCategory productCategory = new ProductCategory();
        if (form.getCategoryId()!=null){
            productCategory = categoryService.findById(form.getCategoryId());
        }
        BeanUtils.copyProperties(form,productCategory);
        try {
            categoryService.save(productCategory);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","index");
            return new ModelAndView("/common/error",map);
        }
        map.put("url","list");
        return new ModelAndView("/common/success",map);
    }
}
