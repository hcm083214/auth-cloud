package com.auth.cloud.grant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.auth.cloud.grant.mapper")
public class GrantApplicaiton {
    public static void main(String[] args) {
        SpringApplication.run(GrantApplicaiton.class, args);
    }
}
