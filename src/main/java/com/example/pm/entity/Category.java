package com.example.pm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.pm.common.base.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author YKH
 * @since 2023-05-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("category")
@ApiModel(value="Category对象", description="")
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;


}
