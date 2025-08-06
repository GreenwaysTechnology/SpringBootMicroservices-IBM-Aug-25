package com.ibm.cloud.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringcloudstreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudstreamApplication.class, args);
    }

    @Bean
    public Supplier<UUID> stringSupplier() {
        return () -> {
            var uuid = UUID.randomUUID();
            return uuid;
        };
    }

    @Bean
    public Consumer<String> stringConsumer() {
        return message -> {
            System.out.println(message);
        };
    }
}
