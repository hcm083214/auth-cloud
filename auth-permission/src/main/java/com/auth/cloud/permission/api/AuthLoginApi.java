package com.auth.cloud.permission.api;

import com.auth.cloud.permission.enums.ApiConstants;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 黄灿民
 * @date 2025/01/02
 */
@FeignClient(value = ApiConstants.NAME)
public interface AuthLoginApi {
}
