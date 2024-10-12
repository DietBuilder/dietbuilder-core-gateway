package com.dietbuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.dietbuilder")
public class DietBuilderEngineGatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(DietBuilderEngineGatewayApp.class);
    }
}
