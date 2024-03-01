package com.auth.cloud.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Swagger 自动配置类，基于 OpenAPI + Springdoc 实现。
 * <p>
 * 友情提示：
 * 1. Springdoc 文档地址：<a href="https://github.com/springdoc/springdoc-openapi">仓库</a>
 * 2. Swagger 规范，于 2015 更名为 OpenAPI 规范，本质是一个东西
 *
 * @author 黄灿民
 * @date 2024/02/27
 */
@AutoConfiguration
@ConditionalOnClass({OpenAPI.class})
@EnableConfigurationProperties(SwaggerProperties.class)
@ConditionalOnProperty(prefix = "springdoc.api-docs", name = "enabled", havingValue = "true", matchIfMissing = true)
public class SwaggerAutoConfiguration {

    // ========== 全局 OpenAPI 配置 ==========
    // TODO：分组 OpenAPI 配置 ； 安全模式，这里配置通过请求头 Authorization 传递 token 参数
    @Bean
    public OpenAPI createOpenApi(SwaggerProperties swaggerProperties) {
        System.out.println("SwaggerAutoConfiguration.createOpenApi()"+swaggerProperties);
        return new OpenAPI()
                .info(buldInfo(swaggerProperties));
    }

    public Info buldInfo(SwaggerProperties swaggerProperties) {
        return new Info()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .version(swaggerProperties.getVersion())
                .contact(new Contact().name(swaggerProperties.getAuthor()).email(swaggerProperties.getEmail()).url(swaggerProperties.getUrl()))
                .license(new License().name(swaggerProperties.getLicense()).url(swaggerProperties.getLicenseUrl()));
    }
}
