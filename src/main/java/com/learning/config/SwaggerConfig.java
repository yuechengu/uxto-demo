package com.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //Swagger的Docket的Bean实例
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("草泥马")
                //.enable(flag)
                .select()
                //basePackage: 指定要扫描的包
                //any: 扫描全部
                //none: 不扫描
                //withClassAnnotation: 扫描类上的注解
                //withMethodAnnotation: 扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.learning.swagger.controller"))
                .paths(PathSelectors.ant("/test/**"))//过滤什么路径
                .build();
    }
    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("guyuechen")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.learning.swagger.controller"))
                //.paths(PathSelectors.ant("/hello/**"))
                .build();
    }
    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("wuzhenyu");
    }

    //Swagger信息 -->apiInfo
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("guyuechen", "", "gyc822@qq.com");

        return new ApiInfo("我的Api文档",
                "我的自定义描述",
                "1.0",
                "https://www.wolai.com/guyuechen/cwScm46xbTq6SztonRPwht",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
