package ru.smv.tgbot.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.smv.tgbot.web.SwaggerInfo;

@Configuration
public class SwaggerConfig {
    @Value("${swagger-api.version}")
    private String swaggerApiVersion;

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info()
                .title(SwaggerInfo.TITLE)
                .description(SwaggerInfo.DESCRIPTION)
                .version(swaggerApiVersion)
        );
    }
}
