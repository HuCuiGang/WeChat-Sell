package com.hcg.sell.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: sell
 * @description: 商品类目
 * @author: hcg
 * @create: 2019-05-17 16:25
 * @Modify By:
 * @updated:
 **/
@Entity
@DynamicUpdate
@Data
public class ProductCategory {
    //类目ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    //类目名称
    private String categoryName;
    //类目编号
    private Integer categoryType;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}

