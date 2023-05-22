package com.example.pm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pm.common.utils.DateTool;
import com.example.pm.mapper.CategoryMapper;
import com.example.pm.entity.Category;
import com.example.pm.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* <p>
    *  服务层实现类
    * </p>
*
* @author YKH
* @since 2023-05-21
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService {


    @Override
    public Boolean add(Category category) {

        this.save(category);
        return true;
    }

    @Override
    public Boolean update(Category category) {
        this.updateById(category);
        return true;
    }

    @Override
    public void deleteByIds(String ids) {
        List<String> listIds = new ArrayList<>();
        String[] aryIds = ids.split(",");
        for(String id: aryIds){
            listIds.add(id);
        }
        this.removeByIds(listIds);
    }

    @Override
    public Boolean updateUsefulByIds(String ids, Boolean flag) {
        //ids  若干个id 用逗号隔开
        String[] aryIds = ids.split(",");
        for(String id: aryIds){

            //查找符合的数据
            UpdateWrapper<Category> UpdateWrapper = new UpdateWrapper();
            UpdateWrapper.eq("id",id);

            //修改数据
            Category category = this.getOne(UpdateWrapper);

            //执行
            this.update(category);
        }
        return true;
    }

    @Override
    public Category getByName(String name){
    QueryWrapper<Category> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("name",name);

        return this.getOne(QueryWrapper);
    }

    @Override
    public Category getById(String id){
    QueryWrapper<Category> QueryWrapper = new QueryWrapper<>();
    QueryWrapper.eq("id",id);

    return this.getOne(QueryWrapper);
    }

    @Override
    public List<Category> list (){
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        return this.list(queryWrapper);
    }

    @Override
    public Page<Category> page(Integer pageNum,Integer pageSize,String name) {
        Page<Category> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);

        return this.page(page,queryWrapper);
    }

}