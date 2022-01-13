package com.aquarius.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: dllAquarius
 * @Date: 2022/1/12
 * @Description:
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMainApplication7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMainApplication7002.class,args);
    }
}
