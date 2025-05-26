package com.zurak.userauth;

import com.google.cloud.spring.data.spanner.repository.config.EnableSpannerRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.actuate.autoconfigure.r2dbc.ConnectionFactoryHealthContributorAutoConfiguration;
import com.google.cloud.spring.autoconfigure.spanner.SpannerTransactionManagerAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.zookeeper.ZookeeperAutoConfiguration;
import org.springframework.cloud.zookeeper.discovery.ZookeeperDiscoveryAutoConfiguration;
import org.springframework.cloud.zookeeper.support.CuratorServiceDiscoveryAutoConfiguration;
import org.springframework.cloud.zookeeper.discovery.reactive.ZookeeperReactiveDiscoveryClientConfiguration;
import org.springframework.cloud.zookeeper.discovery.ZookeeperDiscoveryClientConfiguration;
import org.springframework.cloud.zookeeper.serviceregistry.ZookeeperAutoServiceRegistrationAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        R2dbcAutoConfiguration.class,
        ConnectionFactoryHealthContributorAutoConfiguration.class,
        SpannerTransactionManagerAutoConfiguration.class,
        EurekaClientAutoConfiguration.class,
        //EurekaServiceRegistryAutoConfiguration.class,
        ZookeeperAutoConfiguration.class,
        ZookeeperDiscoveryAutoConfiguration.class,
        CuratorServiceDiscoveryAutoConfiguration.class,
        ZookeeperReactiveDiscoveryClientConfiguration.class,
        ZookeeperDiscoveryClientConfiguration.class,
        ZookeeperAutoServiceRegistrationAutoConfiguration.class
})
@EnableSpannerRepositories
@EnableDiscoveryClient
@EnableFeignClients
public class UserAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAuthServiceApplication.class, args);
    }
}