package com.auth.cloud.grant.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "body参数")
@RequestMapping("/role")
public class Role {
    @Operation(summary = "普通body请求")
    @GetMapping("/body")
    public String body(){
        return "ResponseEntity.ok(fileResp)";
    }

    @Operation(summary = "普通body请求+Param+Header+Path")
    @GetMapping("/bodyParamHeaderPath/{id}")
    public String bodyParamHeaderPath( ){
        return "ResponseEntity.ok(fileResp)";
    }
}
