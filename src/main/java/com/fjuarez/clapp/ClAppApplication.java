package com.fjuarez.clapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.fjuarez.clapp")
public class ClAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClAppApplication.class, args);
    }
}