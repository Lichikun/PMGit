package com.example.pm.controller;

import com.example.pm.common.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.pm.entity.Category;
import com.example.pm.service.CategoryService;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YKH
 * @since 2023-05-21
 */
@RestController
@RequestMapping("//category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @ApiOperation(value = "获取全部分类")
    @RequestMapping(method = RequestMethod.GET,value = "/getAllCategory")
    public Result list(){
        Result result = new Result();
        result.success("获取list成功");
        result.setData(categoryService.list());
        return result;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "需要查找分类的id",required = true,paramType = "query"),
    })
    @ApiOperation(value = "查找分类接口：根据id精确查找分类")
    @RequestMapping(method = RequestMethod.POST,value = "/getCategoryById")
    public Result listById(String id){
        Result result = new Result();
        result.success("获取list成功");
        result.setData(categoryService.getById(id));
        return result;
    }
}
