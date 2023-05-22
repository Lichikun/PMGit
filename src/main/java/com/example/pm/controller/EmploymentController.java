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
 * @since 2023-05-16
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
    @RequestMapping(method = RequestMethod.POST,value = "/updateState")
    public Result updateUsefulByIds(String id,Integer flag) {
        Result result = new Result();
        employmentService.updateUsefulByIds(id,flag);
        result.success("更新成功");
        return result;
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "title",value = "需要查找任务的名字",required = true,paramType = "query"),
    })
    @ApiOperation(value = "查找任务接口：根据姓名模糊查找任务")
    @RequestMapping(method = RequestMethod.POST,value = "/getByTitle")
    public Result list(String title){
        Result result = new Result();
        result.success("获取list成功");
        result.setData(employmentService.list(title));
        return result;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "需要查找任务的id",required = true,paramType = "query"),
    })
    @ApiOperation(value = "查找任务接口：根据id精确查找任务")
    @RequestMapping(method = RequestMethod.POST,value = "/getById")
    public Result listById(String id){
        Result result = new Result();
        result.success("获取list成功");
        result.setData(employmentService.getById(id));
        return result;
    }


    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageNum",value = "第几页",required = true,paramType = "query"),
        @ApiImplicitParam(name = "pageSize",value = "每页的任务数量",required = true,paramType = "query"),
        @ApiImplicitParam(name = "title",value = "需要查找任务的名字",required = true,paramType = "query")
    })
    @ApiOperation(value = "分页查询任务")
    @RequestMapping(method = RequestMethod.POST,value = "/page")
    public Result page( Integer pageNum,Integer pageSize,String title ){
        Result result = new Result();
        result.success("获取list成功");
        result.setData(employmentService.page(pageNum,pageSize,title));
        return result;
    }

    @ApiOperation(value = "按类别查询任务")
    @RequestMapping(method = RequestMethod.GET,value = "/get_tasks_by_categories")
    public Result get_tasks_by_categories( String categoryIds ){
        Result result = new Result();
        if(categoryIds == null || categoryIds.equals("")){
            result.fail("错误：参数为空");
            return result;
        }else {
            result.success("获取任务成功");
            result.setData(employmentService.getByCategories(categoryIds));
            return result;
        }
    }


    @ApiOperation(value = "按类别分页查询任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "第几页",required = true,paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页的任务数量",required = true,paramType = "query"),
            @ApiImplicitParam(name = "categoryIds",value = "需要查找类别的id",required = true,paramType = "query")
    })
    @RequestMapping(method = RequestMethod.GET,value = "/page_tasks_by_categories")
    public Result page_tasks_by_categories( Integer pageNum,Integer pageSize, String categoryIds ){
        Result result = new Result();
        if (categoryIds == null || categoryIds.equals("")){
            result.fail("错误：参数为空");
            return result;
        }else {
            result.success("分页获取任务成功");
            result.setData(employmentService.pageByCategories(pageNum,pageSize,categoryIds));
            return result;
        }
    }

    @ApiOperation(value = "按用户id查询任务")
    @RequestMapping(method = RequestMethod.GET,value = "/get_tasks_by_employer")
    public Result get_tasks_by_categories( String employerIds ){
        Result result = new Result();
        if(employerIds == null || employerIds.equals("")){
            result.fail("错误：参数为空");
        }else {
            result.success("获取任务成功");
            result.setData(employmentService.getByEmployerIds(employerIds));
        }
        return result;
    }


    @ApiOperation(value = "按用户ID分页查询任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "第几页",required = true,paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页的任务数量",required = true,paramType = "query"),
            @ApiImplicitParam(name = "employerIds",value = "需要查找用户的id",required = true,paramType = "query")
    })
    @RequestMapping(method = RequestMethod.GET,value = "/page_tasks_by_employer")
    public Result page_tasks_by_categories( Integer pageNum,Integer pageSize, String employerIds ){
        Result result = new Result();
        if (employerIds == null || employerIds.equals("")){
            result.setData(employerIds);
            result.fail("错误：参数为空");
        }else {
            result.success("分页获取任务成功");
            result.setData(employmentService.pageByEmployerIds(pageNum,pageSize,employerIds));
        }
        return result;
    }



}
