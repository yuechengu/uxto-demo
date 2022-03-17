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
                .groupName("guyuechen")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.learning.controller"))
                //.paths(PathSelectors.ant("/hello/**"))
                .build();
    }

    //Swagger信息 -->apiInfo
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("yuechengu", "https://github.com/yuechengu/uxto-demo", "gyc822@qq.com");

        return new ApiInfo("Transfer Api文档",
                "utxo模型transfer转账接口",
                "1.0",
                "https://www.wolai.com/guyuechen/9qjeuYsPCTrCaprPCHqzw",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
