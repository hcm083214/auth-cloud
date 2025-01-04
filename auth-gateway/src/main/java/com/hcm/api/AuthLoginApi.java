package com.hcm.api;

import com.auth.cloud.common.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Mono;

/**
 * @author 黄灿民
 * @date 2025/01/02
 */
@FeignClient(value = "auth-permission")
public interface AuthLoginApi {

    @PostMapping("/login")
    Mono<CommonResult<String>> login();
}
