package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.jk.mapper")
@EnableDiscoveryClient
public class HhxserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HhxserviceApplication.class, args);
    }

}
