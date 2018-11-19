package com.codesolt.employeeapi.swagger;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
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
        		.groupName("Codesolt - Employee API")
                .apiInfo(apiInfo())
                .select().paths(paths())
                .build();             
    }
    
	private Predicate<String> paths() {
		return or(regex("/oauth/token.*"), regex("/employee.*"));
	}
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Codesolt Employee API")
                .description("REST API for Codesolt Employees")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Carlos Salazar", "https://codesolt.com/", "carlos.salazar@codesolt.com"))
                .build();
    }
    
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
    }
}
