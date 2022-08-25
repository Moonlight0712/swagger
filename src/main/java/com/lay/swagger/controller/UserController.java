package com.lay.swagger.controller;

import com.lay.swagger.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(tags ="User数据交互")
@CrossOrigin
public class UserController
{
    @ApiIgnore  //表示忽略该api，不在swagger中生成
    //只要我们的接口中，返回值中存在实体类，他就会被扫描到Swagger中
    @GetMapping("/User")
    @ApiOperation("展示用户")
    public User showUser(@RequestBody User u)
    {
        return u;
    }

    //只要我们的接口中，返回值中存在实体类，他就会被扫描到Swagger中
    @GetMapping("/UserName")
    @ApiOperation("展示用户名称")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "request success ~~~", response = User.class),
                    @ApiResponse(code = 404, message = "资源找不到")
            }
    )
    //其中required表示当前参数是必须要提供的，默认是false
    public String showUserName(@ApiParam(name = "username",value="新增用户时提供的用户名",required = true) @RequestParam("username") String username)
    {
        return username;
    }

    //完整用法示例
    @ApiOperation(
            value = "根据用户 ID 和 用户名称获取用户信息"
            , notes = "测试"
            , httpMethod = "GET"
            , produces = "application/json"
            , protocols = "http"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户 id 撒", required = true, paramType = "query", dataType = "int")
            , @ApiImplicitParam(name = "name", value = "用户名称撒", paramType = "query", dataType = "String")
    })
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "request success ~~~", response = User.class),
                    @ApiResponse(code = 200, message = "success")
            }
    )
    @GetMapping(value = "/test")
    public User getUserByIdAndName(Integer id, String name) {
        return new User(id, name);
    }


}
