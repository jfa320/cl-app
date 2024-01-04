package com.example.clapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.example.clapp")  // Ajusta el paquete según tu estructura
public class ClAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClAppApplication.class, args);
    }
}