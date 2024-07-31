package com.minhnh.hapedu.infrastructure.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${swagger.contact.mail}")
    private String contactEmail;

    @Value("${swagger.contact.name}")
    private String contactName;

    @Value("${swagger.contact.url}")
    private String contactUrl;

    @Value("${swagger.license.name}")
    private String licenseName;

    @Value("${swagger.license.url}")
    private String licenseUrl;

    @Value("${server.port}")
    private Integer port;

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }

    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail(contactEmail);
        contact.setName(contactName);
        contact.setUrl(contactUrl);

        License mitLicense =
                new License().name(licenseName).url(licenseUrl);

        Info info =
                new Info()
                        .title("Tutorial Management API")
                        .version("2.0")
                        .contact(contact)
                        .description("This API exposes endpoints to manage tutorials.")
                        .license(mitLicense);

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(
                        new Components().addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()))
                .info(info);
    }

    @Bean
    public CommandLineRunner logSwaggerUrl() {
        return args -> {
            String swaggerUrl = "http://localhost:" + port + "/swagger-ui/index.html";
            System.out.println("\nSwagger UI local available at: " + swaggerUrl + "\n");
        };
    }
}

