package com.everis.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfing {

	  /** Bean_para_la_Configuración_del_Swagger.
	   * 
	   * @return Documentación con Swagger UI
	   */
	  @Bean
	  public Docket productApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	        .apis(RequestHandlerSelectors.basePackage("com.everis"))
	        .paths(regex("/api/V1.0.*"))
	        .build()
	        .apiInfo(metaInfo());
	  }

	  private ApiInfo metaInfo() {
	    
	    ApiInfo apiInfo = new ApiInfo(
	        "Spring Boot con Swagger ", 
	        "Spring Boot Primer Proyecto", 
	        "1.0",
	        "Terminos de Servicios", 
	        new Contact("Lukas", "https://github.com/Lukaz66", "lukas_cmlp13@hotmail.com"), 
	        "Apache License Version 2.0",
	        "http://www.apache.org/licenses/LICENSE-2.0"
	    );
	    
	    return apiInfo;
	  }
	
}
