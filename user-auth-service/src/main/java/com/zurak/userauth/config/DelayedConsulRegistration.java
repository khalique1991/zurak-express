/*
package com.zurak.userauth.config;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class DelayedConsulRegistration implements SmartInitializingSingleton {

    private final @Lazy ConsulAutoServiceRegistration registration;

    public DelayedConsulRegistration(@Lazy ConsulAutoServiceRegistration registration) {
        this.registration = registration;
    }

    @Override
    public void afterSingletonsInstantiated() {
        // By this time, hopefully, userRepository and the listener are initialized
        registration.start();
    }
}*/
