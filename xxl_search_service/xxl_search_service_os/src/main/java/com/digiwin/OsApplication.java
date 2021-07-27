package com.digiwin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin.os
 * @ClassName: OsApplication
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/25 15:46
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "com.digiwin.os.dao")
public class OsApplication {
    public static void main(String[] args){
        SpringApplication.run(OsApplication.class);
    }
}
