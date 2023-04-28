package com.example.web3apitest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class Web3ApiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Web3ApiTestApplication.class, args);
    }

}
