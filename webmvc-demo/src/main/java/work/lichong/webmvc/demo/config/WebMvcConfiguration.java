/*
 * Copyright (c) 2022. 李冲. All rights reserved.
 */

package work.lichong.webmvc.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author 李冲
 * @see <a href="https://lichong.work">李冲博客</a>
 * * @since 0.0.1
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 前后分离之后SpringBoot+SpringSecurity放行Swagger访问后,security跨域配置失效的问题
        registry.addViewController("/swagger-ui/")
                .setViewName("forward:/swagger-ui/index.html");
        registry.addRedirectViewController("/", "/index.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(31556926);
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedMethods("*")
                .allowedOriginPatterns("*")
                .allowedHeaders("*");
        super.addCorsMappings(registry);
    }
}
