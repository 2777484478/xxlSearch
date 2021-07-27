package com.digiwin.search.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.digiwin.pojo.Environment;

import java.util.List;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin.search.feign
 * @ClassName: SkuFeign
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/29 13:45
 * @Version: 1.0
 */
@FeignClient(name = "os")
@RequestMapping("/environment")
public interface SkuFeign {
    @GetMapping("/{id}")
    public Environment findOsById(@PathVariable("id") Integer id);
}
