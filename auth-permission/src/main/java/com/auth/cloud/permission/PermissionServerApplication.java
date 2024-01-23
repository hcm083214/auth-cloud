package com.auth.cloud.permission;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 黄灿民
 * @date 2024/01/03
 */
@SpringBootApplication
@MapperScan("com.auth.cloud.permission.mapper")
public class PermissionServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PermissionServerApplication.class, args);
    }
}
