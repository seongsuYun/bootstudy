package com.example.demo.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .consumes(getConsumeContentTypes()) // 요청 contentType
                .produces(getProduceContentTypes()) // 응답 contentType
                .apiInfo(getApiInfo())	// 스웨거 정보 등록
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.api")) // 해당패키지를 탐색해서 API문서를 제작
                //.apis(RequestHandlerSelectors.any()) // 모든 패키지 탐색해서 제작
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                ;
    }

    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        return produces;
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("API")
                .description("[SpringBoot] API")
                .contact(new Contact("Spring Boot Swagger", "https://icast4u.tistory.com/", "icast4u@nate.com"))
                .version("1.0")
                .build();
    }
}
