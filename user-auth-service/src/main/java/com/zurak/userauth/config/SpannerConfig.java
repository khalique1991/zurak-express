package com.zurak.userauth.config;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spring.data.spanner.core.SpannerTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

/**
 * Configuration class for Google Cloud Spanner.
 * Defines the Spanner Transaction Manager.
 */
@Configuration
public class SpannerConfig {

    private final Supplier<DatabaseClient> databaseClientSupplier;

    @Autowired
    public SpannerConfig(Supplier<DatabaseClient> databaseClientSupplier) {
        this.databaseClientSupplier = databaseClientSupplier;
    }

    /**
     * Defines the Spanner Transaction Manager bean.
     *
     * @return An instance of SpannerTransactionManager.
     */
    @Bean
    public SpannerTransactionManager transactionManager() {
        return new SpannerTransactionManager(databaseClientSupplier);
    }
}