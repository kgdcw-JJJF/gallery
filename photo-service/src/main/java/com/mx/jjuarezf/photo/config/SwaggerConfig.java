package com.mx.jjuarezf.photo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2).pathMapping("").apiInfo(apiEndPointsInfo())
                .useDefaultResponseMessages(false).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Photo")
                .description("Manipula datos de usuarios").license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0").build();
    }
}
