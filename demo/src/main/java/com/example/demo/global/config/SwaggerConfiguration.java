package com.example.demo.global.config;

import io.swagger.v3.oas.models.*; import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.*; import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI swaggerConfig() {
        Info info = new Info().title("Swagger Test App")
                .description("description : 스프링 스웨거 설명을 위한 앱 입니다.").version("7.7");
        Components components = new Components().addSecuritySchemes("Authorization",
                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"));
        return new OpenAPI().info(info).components(components)
                .addSecurityItem(new SecurityRequirement().addList("Authorization"));
    }
    @Bean public GroupedOpenApi groupMember(){
        return GroupedOpenApi.builder().group("멤버").pathsToMatch("/member/**").build();
    }
    @Bean public GroupedOpenApi groupPost(){
        return GroupedOpenApi.builder().group("포스트").pathsToMatch("/post/**").build();
    }
}
