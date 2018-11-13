package com.litty.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy  // 开启Zuul的功能
@EnableDiscoveryClient  // 开启eureka注册中心功能
public class ZuulApplication {


    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }


}
