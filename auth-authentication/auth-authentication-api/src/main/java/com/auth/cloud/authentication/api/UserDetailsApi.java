package com.auth.cloud.authentication.api;

import com.auth.cloud.authentication.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-details-service")
public interface UserDetailsApi {

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    @GetMapping("/user/username/{username}")
    UserDTO loadUserByUsername(@PathVariable("username") String username);
}
