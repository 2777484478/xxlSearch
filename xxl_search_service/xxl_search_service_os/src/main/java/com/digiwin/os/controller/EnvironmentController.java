package com.digiwin.os.controller;

import com.digiwin.entity.Result;
import com.digiwin.entity.StatusCode;
import com.digiwin.os.servcie.EnvironmentService;
import com.digiwin.pojo.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin.os.controller
 * @ClassName: EnvironmentController
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/25 17:28
 * @Version: 1.0
 */
@RestController
@RequestMapping("/environment")
public class EnvironmentController {
    @Autowired
    private EnvironmentService environmentService;

    @GetMapping("/all")
    public Result findAll(){
        List<Environment> environmentlist = environmentService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",environmentlist);
    }

    @GetMapping("/{id}")
    public Environment findById(@PathVariable Integer id){
        Environment environment = environmentService.findById(id);
        return environment;
    }

    @PostMapping
    public Result add(@RequestBody Environment environment){
        environmentService.add(environment);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @PostMapping(value = "/{id}")
    public Result update(@RequestBody Environment environment, @PathVariable  Integer id){
        environment.setId(id);
        environmentService.update(environment);
        return new Result(true,StatusCode.OK,"更新成功了");
    }
}
