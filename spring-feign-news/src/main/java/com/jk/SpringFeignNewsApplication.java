package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan("com.jk.*")
public class SpringFeignNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFeignNewsApplication.class, args);
    }

}
