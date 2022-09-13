/*
 * Copyright (c) 2022. 李冲. All rights reserved.
 */

package work.lichong.funcode.webmvc.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lichong
 * @see <a href=MY_HOMEPAGE>李冲博客</a>
 * @since 0.0.1
 */
@Configuration
public class OpenApiConfig {

    @Value("${project.version}")
    private String projectVersion;
    
    private static final String MY_HOMEPAGE = "https://lichong.work";

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Demo系统接口文档")
                        .version(projectVersion)
                        .description("这是一个Demo系统的接口文档")
                        .license(new License().name("GPL-3.0")
                                .url(MY_HOMEPAGE)));
    }

    @Bean
    public GroupedOpenApi userApi() {
        String[] paths = {"/**"};
        String[] packagedToMatch = {"work.lichong.funcode"};
        return GroupedOpenApi.builder().group("SpringBoot的MVC示例")
                .pathsToMatch(paths)
                .packagesToScan(packagedToMatch).build();
    }


}
