package com.example.shareservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.shareservice.mapper")
public class ShareServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShareServiceApplication.class, args);
    }

}
