package com.hanseld.petmpapi.config.doc;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket petMealPlanApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select() 
				.apis(RequestHandlerSelectors.any()) 
				.paths(PathSelectors.any()) 
				.build() 
				.pathMapping("/") 
				.directModelSubstitute(LocalDate.class, String.class) 
				.genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false) 
				.enableUrlTemplating(true);
	 }

	 @Bean
	 UiConfiguration uiConfig() {
		 return UiConfigurationBuilder.builder() 
				 .deepLinking(true)
				 .displayOperationId(false)
				 .defaultModelsExpandDepth(1)
				 .defaultModelExpandDepth(1)
				 .defaultModelRendering(ModelRendering.EXAMPLE)
				 .displayRequestDuration(false)
				 .docExpansion(DocExpansion.NONE)
				 .filter(false)
				 .maxDisplayedTags(null)
				 .operationsSorter(OperationsSorter.ALPHA)
				 .showExtensions(false)
				 .showCommonExtensions(false)
				 .tagsSorter(TagsSorter.ALPHA)
				 .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
				 .validatorUrl(null)
				 .build();
	  }
	  
	  private ApiInfo apiInfo() {
		    return new ApiInfoBuilder()
		        .title("Pet Meal Plan API")
		        .description("A simple API that offers suggest weekly meal planning for pets.")
		        .contact(new Contact("Hansel Donizete", "https://github.com/hanseld28", ""))
		        .license("Apache License Version 2.0")
		        .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
		        .version("1.0")
		        .build();
	  }
}
