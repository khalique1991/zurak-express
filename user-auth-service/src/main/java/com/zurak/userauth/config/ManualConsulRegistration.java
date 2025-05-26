/*
package com.zurak.userauth.config;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistration;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class ManualConsulRegistration implements SmartInitializingSingleton {

    @Autowired(required = false)
    private ConsulAutoServiceRegistration registration;

    @Override
    public void afterSingletonsInstantiated() {
        if (registration != null) {
            registration.start();
            System.out.println("Consul service registration started manually.");
        } else {
            System.out.println("ConsulAutoServiceRegistration bean not found.");
        }
    }
}*/
