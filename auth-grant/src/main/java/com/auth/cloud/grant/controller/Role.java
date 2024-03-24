package com.auth.cloud.grant.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/role")
public class Role {

    @GetMapping("/body")
    public String body(){
        return "ResponseEntity.ok(fileResp)";
    }


    @GetMapping("/bodyParamHeaderPath/{id}")
    public String bodyParamHeaderPath( ){
        return "ResponseEntity.ok(fileResp)";
    }
}
