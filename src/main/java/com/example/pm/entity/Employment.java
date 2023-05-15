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
 * @since 2023-05-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("employment")
@ApiModel(value="Employment对象", description="")
public class Employment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String salary;

    private String ename;

    private String employer;

    private String address;

    private String time;

    private String msg;

    private String tel;

    private String email;

    private String require;

    private String edu;

    private String category;

    private String state;
}
