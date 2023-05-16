package com.example.pm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pm.common.utils.DateTool;
import com.example.pm.mapper.EmploymentMapper;
import com.example.pm.entity.Employment;
import com.example.pm.service.EmploymentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* <p>
    *  服务层实现类
    * </p>
*
* @author YKH
* @since 2023-05-16
*/
@Service
public class EmploymentServiceImpl extends ServiceImpl<EmploymentMapper,Employment> implements EmploymentService {


    @Override
    public Boolean add(Employment employment) {
        employment.setCreatetime(DateTool.getCurrTime());
        employment.setState(1);
        this.save(employment);
        return true;
    }

    @Override
    public Boolean update(Employment employment) {
        this.updateById(employment);
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
    public Boolean updateUsefulByIds(String ids, Integer flag) {
        //ids  若干个id 用逗号隔开
        String[] aryIds = ids.split(",");
        for(String id: aryIds){

            //查找符合的数据
            UpdateWrapper<Employment> UpdateWrapper = new UpdateWrapper();
            UpdateWrapper.eq("id",id);

            //修改数据
            Employment employment = this.getOne(UpdateWrapper);
            employment.setState(flag);

            //执行
            this.update(employment);
        }
        return true;
    }

    @Override
    public Employment getByName(String title){
    QueryWrapper<Employment> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("title",title);

        return this.getOne(QueryWrapper);
    }

    @Override
    public Employment getById(String id){
        QueryWrapper<Employment> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("id",id);

        return this.getOne(QueryWrapper);
    }

    @Override
    public List<Employment> list (String title){
        QueryWrapper<Employment> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("title",title);

            return this.list(queryWrapper);
    }

    @Override
    public Page<Employment> page(Integer pageNum,Integer pageSize,String title) {
        Page<Employment> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Employment> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title",title);

        return this.page(page,queryWrapper);
    }

}