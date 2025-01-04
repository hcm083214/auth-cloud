package com.hcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 黄灿民
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.hcm.api"})
public class AuthGatewayApplicaiton {
    public static void main(String[] args) {
        SpringApplication.run(AuthGatewayApplicaiton.class,args);
    }
}
