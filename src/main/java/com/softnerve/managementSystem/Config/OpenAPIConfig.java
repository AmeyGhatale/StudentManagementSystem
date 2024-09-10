package com.softnerve.managementSystem.Config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info().title("Student Management System"))
                .addSecurityItem(new SecurityRequirement().addList("JavaInUseSecurityScheme"))
                .components(new Components().addSecuritySchemes("JavaInUseSecurityScheme", new SecurityScheme()
                        .name("JWT Token Authentication").type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));

    }
}



















//
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
//import io.swagger.v3.oas.annotations.info.Contact;
//import io.swagger.v3.oas.annotations.info.Info;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import io.swagger.v3.oas.annotations.security.SecurityScheme;
//
//
//@OpenAPIDefinition(
//        info = @Info(
//            title = "Book My Show Application",
//            description = "Movie Booking Ticket Platform" ,
//                   contact = @Contact(
//                    name = "Amey Ghatale",
//                    email = "ameyghatale2016@gmail.com"
//                   ) ,
//                    version = "v1"
//        ),
//        security = @SecurityRequirement(
//                name = " auth "
//        )
//)
//
//@SecurityScheme(
//        name = "JWT Authentication",
//        in = SecuritySchemeIn.HEADER,
//        type = SecuritySchemeType. HTTP ,
//        bearerFormat = "JWT",
//        scheme = "bearer" ,
//        description = "User/Admin login using JWT Token"
//)
//
//public class OpenAPIConfig {
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import springfox.documentation.builders.ApiInfoBuilder;
////import springfox.documentation.builders.PathSelectors;
////import springfox.documentation.builders.RequestHandlerSelectors;
////import springfox.documentation.service.ApiInfo;
////import springfox.documentation.spi.DocumentationType;
////import springfox.documentation.spring.web.plugins.Docket;
////import springfox.documentation.swagger2.annotations.EnableSwagger2;
////import springfox.documentation.service.Contact;
////
////
////@Configuration
////@EnableSwagger2
////public class OpenAPIConfig {
////
////    @Bean
////    public Docket api() {
////        return new Docket(DocumentationType.SWAGGER_2)
////                .select()
////                .apis(RequestHandlerSelectors.basePackage("com.natwest.scholarshipEligibility.Controller"))
////                .paths(PathSelectors.any())
////                .build().apiInfo(metaData())
////                .useDefaultResponseMessages(false);
////    }
////
////    private ApiInfo metaData() {
////        return new ApiInfoBuilder()
////                .title("Scholarship Eligibility")
////                .description("Students eligibility for scholarship program")
////                .version("version 1.0")
////                .contact(new Contact("Amey Ghatale", "","ameyghatale2016@gmail.com")).build();
////    }
////}
////
////
