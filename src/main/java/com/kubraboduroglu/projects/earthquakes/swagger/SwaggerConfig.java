package com.kubraboduroglu.projects.earthquakes.swagger;  
import java.time.LocalDate;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
//@EnableSwagger2
//@ComponentScan(basePackages = "com.kubraboduroglu.projects.earthquakes")
public class SwaggerConfig {

	@Bean
	  public OpenAPI meetingOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Earthqueks Info API")
	              .description("Project for REST with Spring Boot")
	              .version("v0.0.1")
	              .contact(new Contact().name("Kubra Boduroglu"))
	              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
	              /*.externalDocs(new ExternalDocumentation()
	              .description("SpringShop Wiki Documentation")
	              .url("https://springshop.wiki.github.org/docs"))*/ ;
	  }
	
	
	/*    
    @Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)	
				.select()
				.apis(RequestHandlerSelectors.any())              
		        .paths(PathSelectors.any())
		        .apis(RequestHandlerSelectors.basePackage("com.kboduroglu.meeting"))              
		        .paths(PathSelectors.regex("/meeting.*"))
		        .build()
		        .directModelSubstitute(LocalDate.class, String.class)
		        .genericModelSubstitutes(ResponseEntity.class)
		        .apiInfo(apiInfo());
		        
    }
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring REST  V1")
				.description("Example Project for REST with Spring Boot")
				.contact(new Contact("Kubra Boduroglu", "", ""))
				.license("License")
				.version("1.0")
				.build();
	}
	 */	
}

