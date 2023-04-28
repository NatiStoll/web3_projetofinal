package com.example.web3apieureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Web3ApiEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Web3ApiEurekaApplication.class, args);
    }

}
