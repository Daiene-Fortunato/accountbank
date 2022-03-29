package br.com.accountbank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
    private Contact contato() {
    	return new Contact(
    			"Daiene Fortunato",
    			"https://github.com/Daiene-Fortunato",
    			"daiene.fortunato@gmail.com");
    }

    private ApiInfoBuilder informacoesApi() {
    	ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
    	
        apiInfoBuilder.title("ACCOUNT BANK - REST API");
        apiInfoBuilder.description("Final Project - IT Experts");
        apiInfoBuilder.version("1.0.0");
        apiInfoBuilder.termsOfServiceUrl("Terms of Use: Open Source");
        apiInfoBuilder.license("License - Apache License Version 2.0");
        apiInfoBuilder.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;
        
    }
    
    @Bean
    public Docket detalheApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.accountbank"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build());

        return docket;
    }

}
