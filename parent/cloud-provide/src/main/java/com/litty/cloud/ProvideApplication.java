package com.litty.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages = {"com.litty.cloud.mapper"})
// @EnableEurekaClient //本服务启动后会自动注册进 Eureka 服务
@EnableDiscoveryClient //服务发现
public class ProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvideApplication.class,args);
    }
}
