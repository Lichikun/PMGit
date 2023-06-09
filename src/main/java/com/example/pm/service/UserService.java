package com.example.pm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pm.entity.User;

import java.util.List;

/**
* <p>
    *  服务类接口
    * </p>
 *
*
* @author YKH
* @since 2023-05-16
*/
public interface UserService extends IService<User> {

    Boolean add(User user);
    void deleteByIds(String ids);
    Boolean update(User user);
    User getById(String id);
    User getByName(String name);
    List<User> list(String id);
    Boolean updateUsefulByIds(String id, Integer flag);
    Page<User> page(Integer pageNum, Integer pageSize, String name);
}