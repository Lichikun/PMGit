package com.example.pm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.pm.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;

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
@TableName("employment")
@ApiModel(value="Employment对象", description="")
public class Employment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "任务标题(例如：洗碗工，普工)")
    private String title;

    @ApiModelProperty(value = "雇主名称")
    private String employer;

    @ApiModelProperty(value = "发布任务用户ID")
    @TableField("employerID")
    private String employerID;

    @ApiModelProperty(value = "雇主电话")
    private String tel;

    @ApiModelProperty(value = "当前状态(1--等待接单2--已接单3--已完成4--已取消)")
    private Integer state;

    @ApiModelProperty(value = "图片描述")
    private String img;

    @ApiModelProperty(value = "联系邮箱")
    private String email;

    @ApiModelProperty(value = "工作地址")
    private String address;

    @ApiModelProperty(value = "工作描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private String createtime;

    @ApiModelProperty(value = "工作时间")
    private String worktime;

    @ApiModelProperty(value = "截止时间")
    private String endtime;

    @ApiModelProperty(value = "分类")
    private Integer category;

    @ApiModelProperty(value = "工资上限")
    private Integer maxsalary;

    @ApiModelProperty(value = "工资下限")
    private Integer minsalary;

    @ApiModelProperty(value = "所需教育程度")
    private String education;

    @ApiModelProperty(value = "接受任务用户ID")
    @TableField("employeeID")
    private String employeeID;


}
