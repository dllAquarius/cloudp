package com.aquarius.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: dllAquarius
 * @Date: 2022/1/13
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMainApplication8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMainApplication8006.class, args);
    }
}
