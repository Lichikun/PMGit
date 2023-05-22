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
 * @since 2023-05-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user")
@ApiModel(value="User对象", description="")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名(用户登入账号,唯一不重复)")
    private String name;

    @ApiModelProperty(value = "用户登入密码")
    private String password;

    @ApiModelProperty(value = "用户联系方式")
    private String tel;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "用户状态(1--启用2--停用)")
    private Integer state;


}
