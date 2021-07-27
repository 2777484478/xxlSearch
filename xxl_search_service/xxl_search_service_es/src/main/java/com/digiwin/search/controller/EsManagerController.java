package com.digiwin.search.controller;

import com.digiwin.entity.Result;
import com.digiwin.entity.StatusCode;
import com.digiwin.search.service.EsManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin.search.controller
 * @ClassName: EsManagerController
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/29 10:56
 * @Version: 1.0
 */
@RestController
@RequestMapping("/manager")
public class EsManagerController {
    @Autowired
    private EsManagerService esManagerService;

    @RequestMapping("/create")
    public Result createIndexAndMaping(){
        esManagerService.createIndexAndMaping();
        return new Result(true, StatusCode.OK,"创建索引库成功");
    }

    @RequestMapping("/imdata/{id}")
    public Result install(@PathVariable("id") Integer id){
        esManagerService.importDataToEs(id);
        return new Result(true, StatusCode.OK,"导入数据到ES成功");
    }

}
