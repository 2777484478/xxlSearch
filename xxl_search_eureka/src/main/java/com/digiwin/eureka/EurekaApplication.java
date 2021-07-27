package com.digiwin.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin.eureka
 * @ClassName: EurekaApplication
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/24 17:37
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args){
        SpringApplication.run(EurekaApplication.class);
    }
}
