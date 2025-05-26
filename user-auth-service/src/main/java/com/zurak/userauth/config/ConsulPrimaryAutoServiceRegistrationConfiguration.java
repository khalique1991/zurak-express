/*
package com.zurak.userauth.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConsulPrimaryAutoServiceRegistrationConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(value = "spring.cloud.consul.enabled", matchIfMissing = true)
    @Lazy
    public ConsulAutoServiceRegistration consulPrimaryAutoServiceRegistration(@Lazy ConsulAutoServiceRegistration registration) {
        return registration;
    }
}*/
