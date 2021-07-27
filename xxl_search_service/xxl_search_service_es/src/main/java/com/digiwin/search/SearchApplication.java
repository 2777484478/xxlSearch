package com.digiwin.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin
 * @ClassName: SearchApplication
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/28 16:02
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.digiwin.search.feign")
//扫描os_api里面的包
public class SearchApplication {

    public static void main(String[] args){
        SpringApplication.run(SearchApplication.class);
    }

}
