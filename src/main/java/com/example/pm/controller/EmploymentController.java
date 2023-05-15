package com.example.pm.controller;

import com.example.pm.common.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.pm.entity.Employment;
import com.example.pm.service.EmploymentService;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YKH
 * @since 2023-05-14
 */
@RestController
@RequestMapping("//employment")
public class EmploymentController {
    @Autowired
    private EmploymentService employmentService;

    @ApiOperation(value = "发布任务接口:保存Employment信息")
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public Result save(@RequestBody Employment employment) {

        Result result = new Result();

        employmentService.add(employment);
        result.success("添加成功");

        return result;
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "ids",value = "需要删除的ID，多个ID通过,(逗号)隔开",required = true,paramType = "query")
    })
    @ApiOperation(value = "删除任务接口:根据输入id删除Employment信息")
    @RequestMapping(method = RequestMethod.POST, value = "/deleteByIds")
    public Result deleteByIds(String ids){
        Result result = new Result();
        employmentService.deleteByIds(ids);
        result.success("删除成功");

        return result;
    }

    @ApiOperation(value = "更新任务信息接口：根据ID更新任务信息")
    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public Result update(@RequestBody Employment employment){
        Result result = new Result();
        employmentService.update(employment);
        result.success("修改成功");
        return result;
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",value = "需要更改状态的ID",required = true,paramType = "query"),
        @ApiImplicitParam(name = "flag",value = "需要更改成为的状态",required = true,paramType = "query")
    })
    @ApiOperation(value = "更新任务状态接口：根据ID更改停状态")
    @RequestMapping(method = RequestMethod.POST,value = "/updateUsefulByIds")
    public Result updateUsefulByIds(String id,String flag) {
        Result result = new Result();
        employmentService.updateUsefulByIds(id,flag);
        result.success("更新成功");
        return result;
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "name",value = "需要查找书籍的名字",required = true,paramType = "query"),
    })
    @ApiOperation(value = "查找任务接口：根据姓名模糊查找书籍")
    @RequestMapping(method = RequestMethod.POST,value = "/list")
    public Result list(String name){
        Result result = new Result();
        result.success("获取list成功");
        result.setData(employmentService.list(name));
        return result;
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageNum",value = "第几页",required = true,paramType = "query"),
        @ApiImplicitParam(name = "pageSize",value = "每页的书籍数量",required = true,paramType = "query"),
        @ApiImplicitParam(name = "name",value = "需要查找书籍的名字",required = true,paramType = "query")
    })
    @ApiOperation(value = "分页查询任务")
    @RequestMapping(method = RequestMethod.POST,value = "/page")
    public Result page( Integer pageNum,Integer pageSize,String name ){
        Result result = new Result();
        result.success("获取list成功");
        result.setData(employmentService.page(pageNum,pageSize,name));
        return result;
    }
}
