package com.shanbin.cai.demo.config;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings({"unused"})
@Configuration
@EnableSwagger2
public class Swagger2Config {

//    @Value("${swagger2.enable}")
//    private boolean enable;

    @Bean("UserApis")
    public Docket userApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                    .groupName("CustomApi")
                    .select()
                    .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                    .paths(PathSelectors.regex("/girls"))
                    .build()
                    .apiInfo(apiinfo())
                    .enable(true);
    }

    private ApiInfo apiinfo() {
        return new ApiInfoBuilder()
                    .title("测试接口文档")
                    .description("...")
                    .version("1.0")
                    .build();
    }
}
