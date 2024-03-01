package com.auth.cloud.swagger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotEmpty;

/**
 * @author 黄灿民
 * @date 2024/02/27
 */
@Data
@ConfigurationProperties(prefix = "auth.swagger")
public class SwaggerProperties {
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 作者
     */
    private String author;
    /**
     * 版本
     */
    private String version;
    /**
     * url
     */
    private String url;
    /**
     * email
     */
    private String email;

    /**
     * license
     */
    private String license;

    /**
     * license-url
     */
    private String licenseUrl;
}
