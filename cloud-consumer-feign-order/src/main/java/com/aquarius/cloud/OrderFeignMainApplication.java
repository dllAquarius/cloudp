package com.aquarius.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: dllAquarius
 * @Date: 2022/1/14
 * @Description:
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMainApplication.class,args);
    }
}
