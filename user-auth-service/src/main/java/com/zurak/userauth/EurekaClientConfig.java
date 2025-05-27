/*
package com.zurak.userauth;

import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EurekaClientConfig {

    @Bean
    public EurekaClientConfigBean eurekaClientConfigBean() {
        EurekaClientConfigBean config = new EurekaClientConfigBean();
        config.setRegisterWithEureka(true);
        config.setFetchRegistry(true);
        config.setServiceUrl(java.util.Collections.singletonMap("defaultZone", "http://eureka:password123@localhost:8761/eureka"));
        return config;
    }
}*/
