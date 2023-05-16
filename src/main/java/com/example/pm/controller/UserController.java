package com.example.pm.controller;

import com.example.pm.common.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.pm.entity.User;
import com.example.pm.service.UserService;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YKH
 * @since 2023-05-16
 */
@RestController
@RequestMapping("//user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "注册用户接口：保存User信息,若username不存在添加成功,否则失败；" +
            "其中id由系统自动生成，其他按输入设置")
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public Result save(@RequestBody User user) {
        User FindUser = userService.getByName(user.getName());
        Result result = new Result();
        //业务 交给业务成 service 去处理
        if(FindUser != null){
            result.fail(user.getName()+"已存在");
        }else{
            userService.add(user);
            result.success("添加成功");}

        return result;
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "ids",value = "需要删除的ID，多个ID通过,(逗号)隔开",required = true,paramType = "query")
    })
    @ApiOperation(value = "删除用户接口：根据用户id删除User信息")
    @RequestMapping(method = RequestMethod.POST, value = "/deleteByIds")
    public Result deleteByIds(String ids){
        Result result = new Result();
        userService.deleteByIds(ids);
        result.success("删除成功");

        return result;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "需要登入用户的账号",required = true,paramType = "query"),
            @ApiImplicitParam(name = "password",value = "需要登入用户的密码",required = true,paramType = "query")
    })
    @ApiOperation(value = "用户登入接口：根据用户usernamr和password登入")
    @RequestMapping(method = RequestMethod.POST, value = "/userLogin")
    public Result login(String username,String password){
        Result result = new Result();
        User FindUser = userService.getByName(username);
        if(FindUser == null || !FindUser.getPassword().equals(password) ){
            result.fail("用户名不存在或密码错误"+username+password);
            result.setData(FindUser);
        }else{
            result.success("登入成功");}
        return result;
    }

    @ApiOperation(value = "更新用户信息接口:根据id更新用户数据，未输入字段将置空")
    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public Result update(@RequestBody User user){
        Result result = new Result();
        //业务 交给业务成 service 去处理
        userService.update(user);
        result.success("更新成功");
        return result;
    }


    @ApiImplicitParams({
        @ApiImplicitParam(name = "name",value = "需要查找用户的名字",required = true,paramType = "query"),
    })
    @ApiOperation(value = "用户查询接口(username):根据username精确查询查找用户")
    @RequestMapping(method = RequestMethod.POST,value = "/getUserByName")
    public Result list(String name){
        Result result = new Result();
        result.success("查询成功");
        result.setData(userService.getByName(name));
        return result;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "需要查找用户的ID",required = true,paramType = "query"),
    })
    @ApiOperation(value = "用户查询接口(ID):根据ID精确查询查找用户")
    @RequestMapping(method = RequestMethod.POST,value = "/getUserById")
    public Result listbyid(String id){
        Result result = new Result();
        result.success("查询成功");
        result.setData(userService.getById(id));
        return result;
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageNum",value = "第几页",required = true,paramType = "query"),
        @ApiImplicitParam(name = "pageSize",value = "每页的书籍数量",required = true,paramType = "query"),
        @ApiImplicitParam(name = "name",value = "需要查找书籍的名字",required = true,paramType = "query")
    })
    @ApiOperation(value = "信息分页查询接口")
    @RequestMapping(method = RequestMethod.POST,value = "/page")
    public Result page( Integer pageNum,Integer pageSize,String name ){
        Result result = new Result();
        result.success("获取list成功");
        result.setData(userService.page(pageNum,pageSize,name));
        return result;
    }
}
