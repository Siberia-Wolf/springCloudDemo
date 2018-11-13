package com.litty.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.litty.cloud.mapper"})
@EnableDiscoveryClient
public class ProvideApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(ProvideApplication2.class,args);
    }


}
