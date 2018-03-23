package com.wb.springboot2skeleton.web.controller;

import com.wb.springboot2skeleton.Hystrix.CommandHelloWorld;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCtrl {
    @GetMapping("/test")
    @ApiOperation(value = "测试", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    public String test() {
        return "success";
    }
}
