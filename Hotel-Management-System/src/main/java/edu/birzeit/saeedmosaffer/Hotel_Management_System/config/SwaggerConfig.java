package edu.birzeit.saeedmosaffer.Hotel_Management_System.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    // Information about the API
    private Info apiInfo(){
        return new Info().title("Hotel Management System").description("Services Application ").version("1")
                .contact(new Contact().name("Saeed Mosaffer")
                        .url( "www.saeedmosaffer.com")
                        .email( "saeedmosaffer39@gmail.com"));
    }

    @Bean
    public OpenAPI api(){
        return new OpenAPI()
                .components(
                        new Components().addSecuritySchemes(AUTHORIZATION_HEADER,
                                new SecurityScheme().type(SecurityScheme.Type.APIKEY)
                                        .in(SecurityScheme.In.HEADER)
                                        .name(AUTHORIZATION_HEADER)
                                        .bearerFormat("JWT")))

                .info(apiInfo())

                .addSecurityItem(
                        new SecurityRequirement().addList(AUTHORIZATION_HEADER, Collections.singletonList("global")));

    }

}
