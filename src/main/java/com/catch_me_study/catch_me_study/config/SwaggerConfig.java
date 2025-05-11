package com.catch_me_study.catch_me_study.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .version("0.1.0")
                        .title("catch-me-study-api")
                        .description("CatchMe Back-end Study API Document")
                );
    }

    @Bean
    public GroupedOpenApi api() {
        String[] paths = {"/**"};
        String[] packagesToScan = {"com.catch_me_study.catch_me_study"};

        return GroupedOpenApi.builder()
                .group("catch-me-study-api")
                .pathsToMatch(paths)
                .packagesToScan(packagesToScan)
                .build();
    }
}
