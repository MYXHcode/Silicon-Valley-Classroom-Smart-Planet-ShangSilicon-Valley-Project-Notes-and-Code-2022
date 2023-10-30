package com.myxh.smart.planet.swagger;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MYXH
 * @date 2023/9/29
 */
@Configuration
public class SwaggerConfig
{
    @Bean
    public GroupedOpenApi webApiConfig()
    {
        return GroupedOpenApi.builder()
                .group("smart.planet")
                .pathsToMatch("/admin/**")
                .addOpenApiMethodFilter(method -> true)
                .build();
    }

    private OpenAPI webApiInfo()
    {
        return new OpenAPI()
                .info(new Info().title("网站-API文档")
                        .description("本文档描述了网站微服务接口定义")
                        .version("0.0.1-SNAPSHOT")
                        .license(new License().name("GNU GENERAL PUBLIC LICENSE Version 3")
                                .url("https://www.gnu.org/licenses/gpl-3.0.html")))
                .externalDocs(new ExternalDocumentation()
                        .description("智慧星球官网")
                        .url("https://myxh.smart.planet.com"));
    }
}