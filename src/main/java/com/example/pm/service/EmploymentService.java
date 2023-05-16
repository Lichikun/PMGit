package com.example.pm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pm.entity.Employment;

import java.util.List;

/**
* <p>
    *  服务类接口
    * </p>
*
* @author YKH
* @since 2023-05-16
*/
public interface EmploymentService extends IService<Employment> {

    Boolean add(Employment employment);
    void deleteByIds(String ids);
    Boolean update(Employment employment);
    Employment getByName(String name);
    List<Employment> list(String id);
    Employment getById(String id);
    Boolean updateUsefulByIds(String id, Integer flag);
    Page<Employment> page(Integer pageNum, Integer pageSize, String name);
}