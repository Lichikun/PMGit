package com.example.pm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.pm.common.base.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

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
    // 任务标题，例如：洗碗工、普工
    private String title;
    // 雇主名称
    private String employer;
    // 发布任务用户ID
    private String employerId;
    // 雇主电话
    private String tel;
    // 当前状态（1--等待接单2--已接单3--已完成4--已取消）
    private Integer state;
    // 图片描述
    private String img;
    // 联系邮箱
    private String email;
    // 工作地址
    private String address;
    // 工作描述
    private String description;
    // 创建时间
    private String createTime;
    // 工作时间
    private String workTime;
    // 截止时间
    private String endTime;
    // 分类
    private Integer category;
    // 工资上限
    private Integer maxSalary;
    // 工资下限
    private Integer minSalary;
    // 所需教育程度
    private String education;
    // 接受任务用户ID
    private String employeeId;
}
