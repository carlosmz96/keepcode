package com.keepcode.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(new Info().title("Project Spring-Boot 3 - keepcode")
                .version("0.0.1-SNAPSHOT").description("Api for a code management application")
                .license(new License().name("GPL").url("https://www.gnu.org/licenses/gpl-3.0.html"))
                .termsOfService("https://terms_of_service_url.com"));
    }
    
}