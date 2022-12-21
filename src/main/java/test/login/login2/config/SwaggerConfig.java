package test.login.login2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("Authorization")
    private String JWT_HEADER;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("login2 REST API")
                .description("login2 REST API Document")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket userSwagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("login2 API")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("test.login.login2.controller"))
                .paths(PathSelectors.ant("/"))
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", JWT_HEADER, "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.ant("/user/**"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = {authorizationScope};

        return List.of(new SecurityReference("JWT", authorizationScopes));
    }
}
