package com.task.multithreading.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = "com.task")
@EntityScan(basePackages = "com.task.multithreading.entity")
@EnableJpaRepositories(basePackages = "com.task.multithreading.repository.impl")
public class MultithreadingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultithreadingApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public WebClient webClient(){
        return WebClient.create();
    }

}
