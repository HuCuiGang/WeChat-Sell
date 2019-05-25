package com.hcg.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @program: sell
 * @description: 类目表单
 * @author: hcg
 * @create: 2019-05-23 13:35
 * @modify by:
 * @updated:
 **/
@Data
public class CategoryForm {
    //类目ID
    private Integer categoryId;
    //类目名称
    @NotNull(message = "类目名称必填")
    private String categoryName;
    //类目编号
    @NotNull(message = "类目Type必填")
    private Integer categoryType;
}
