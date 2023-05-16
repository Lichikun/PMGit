package com.example.pm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pm.common.utils.DateTool;
import com.example.pm.mapper.UserMapper;
import com.example.pm.entity.User;
import com.example.pm.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


    @Override
    public Boolean add(User user) {
        user.setState(1);
        this.save(user);
        return true;
    }

    @Override
    public Boolean update(User user) {
        this.updateById(user);
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
            UpdateWrapper<User> UpdateWrapper = new UpdateWrapper();
            UpdateWrapper.eq("id",id);

            //修改数据
            User user = this.getOne(UpdateWrapper);
            user.setState(flag);

            //执行
            this.update(user);
        }
        return true;
    }

    @Override
    public User getByName(String name){
    QueryWrapper<User> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("name",name);

        return this.getOne(QueryWrapper);
    }

    @Override
    public User getById(String id){
    QueryWrapper<User> QueryWrapper = new QueryWrapper<>();
    QueryWrapper.eq("id",id);

    return this.getOne(QueryWrapper);
    }

    @Override
    public List<User> list (String name){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("name",name);

            return this.list(queryWrapper);
    }

    @Override
    public Page<User> page(Integer pageNum,Integer pageSize,String name) {
        Page<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);

        return this.page(page,queryWrapper);
    }

}