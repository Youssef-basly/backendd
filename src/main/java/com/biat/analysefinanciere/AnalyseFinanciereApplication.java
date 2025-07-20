package com.biat.analysefinanciere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.biat.analysefinanciere")
public class AnalyseFinanciereApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnalyseFinanciereApplication.class, args);
    }
}