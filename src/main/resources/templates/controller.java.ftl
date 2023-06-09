package ${package.Controller};

import com.example.pm.common.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>


/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}
<#else>
public class ${table.controllerName} {
    @Autowired
    private ${table.serviceName} ${table.entityPath}Service;

    <#if swagger2>
    @ApiOperation(value = "保存${entity}信息")
    </#if>
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public Result save(@RequestBody ${entity} ${table.entityPath}) {
        ${entity} Find${entity} = ${table.entityPath}Service.getByName(${table.entityPath}.getName());
        Result result = new Result();
        //业务 交给业务成 service 去处理
        if(Find${entity} != null){
            result.fail(${table.entityPath}.getName()+"已存在");
        }else{
            ${table.entityPath}Service.add(${table.entityPath});
            result.success("添加成功");}

        return result;
    }

    <#if swagger2>
    @ApiImplicitParams({
        @ApiImplicitParam(name = "ids",value = "需要删除的ID，多个ID通过,(逗号)隔开",required = true,paramType = "query")
    })
    @ApiOperation(value = "修改${entity}信息")
    </#if>
    @RequestMapping(method = RequestMethod.POST, value = "/deleteByIds")
    public Result deleteByIds(String ids){
        Result result = new Result();
        ${table.entityPath}Service.deleteByIds(ids);
        result.success("删除成功");

        return result;
    }

    <#if swagger2>
    @ApiOperation(value = "更新书籍信息")
    </#if>
    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public Result update(@RequestBody ${entity} ${table.entityPath}){
        Result result = new Result();
        ${entity} Find${entity} = ${table.entityPath}Service.getByName(${table.entityPath}.getName());
        if(Find${entity}!=null && !Find${entity}.getId().equals(${table.entityPath}.getId())){
            result.fail("书名"+${table.entityPath}.getName()+"已存在");
        }else{
            ${table.entityPath}Service.update(${table.entityPath});
            result.success("修改成功");
        }
        return result;
    }

    <#if swagger2>
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id",value = "需要更改状态的ID",required = true,paramType = "query"),
        @ApiImplicitParam(name = "flag",value = "需要更改成为的状态",required = true,paramType = "query")
    })
    @ApiOperation(value = "根据ID更改启停状态")
    </#if>
    @RequestMapping(method = RequestMethod.POST,value = "/updateUsefulByIds")
    public Result updateUsefulByIds(String id,Boolean flag) {
        Result result = new Result();
        ${table.entityPath}Service.updateUsefulByIds(id,flag);
        result.success("更新成功");
        return result;
    }

    <#if swagger2>
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name",value = "需要查找书籍的名字",required = true,paramType = "query"),
    })
    @ApiOperation(value = "根据姓名查找书籍")
    </#if>
    @RequestMapping(method = RequestMethod.POST,value = "/list")
    public Result list(String name){
        Result result = new Result();
        result.success("获取list成功");
        result.setData(${table.entityPath}Service.list(name));
        return result;
    }

    <#if swagger2>
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageNum",value = "第几页",required = true,paramType = "query"),
        @ApiImplicitParam(name = "pageSize",value = "每页的书籍数量",required = true,paramType = "query"),
        @ApiImplicitParam(name = "name",value = "需要查找书籍的名字",required = true,paramType = "query")
    })
    @ApiOperation(value = "分页查询书籍")
    </#if>
    @RequestMapping(method = RequestMethod.POST,value = "/page")
    public Result page( Integer pageNum,Integer pageSize,String name ){
        Result result = new Result();
        result.success("获取list成功");
        result.setData(${table.entityPath}Service.page(pageNum,pageSize,name));
        return result;
    }
}
</#if>
