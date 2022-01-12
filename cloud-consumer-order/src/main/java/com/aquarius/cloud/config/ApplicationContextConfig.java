package com.aquarius.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: dllAquarius
 * @Date: 2022/1/11
 * @Description:
 */
@Configuration
public class ApplicationContextConfig {
    // application.xml  <bean id ="",class="">
    @Bean
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}
