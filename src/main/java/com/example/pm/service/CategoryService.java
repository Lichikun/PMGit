package com.example.pm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pm.entity.Category;

import java.util.List;

/**
* <p>
    *  服务类接口
    * </p>
*
* @author YKH
* @since 2023-05-21
*/
public interface CategoryService extends IService<Category> {

    Boolean add(Category category);
    void deleteByIds(String ids);
    Boolean update(Category category);
    Category getById(String id);
    Category getByName(String name);
    List<Category> list();
    Boolean updateUsefulByIds(String id, Boolean flag);
    Page<Category> page(Integer pageNum, Integer pageSize, String name);
}