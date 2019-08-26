package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.jk.*")
@MapperScan("com.jk.dao")
public class CarproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarproviderApplication.class, args);
    }

}
