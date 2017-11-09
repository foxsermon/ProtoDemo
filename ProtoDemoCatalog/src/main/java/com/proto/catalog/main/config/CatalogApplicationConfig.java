package com.proto.catalog.main.config;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.proto.demo.config.CoreConfig;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.proto.catalog.demo"})
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.proto.catalog.demo")
@EnableWebMvc
@Import(value = {CoreConfig.class, ResourceServerConfiguration.class})
@EnableSwagger2
@PropertySource("classpath:documentation.properties")
@CrossOrigin(allowCredentials = "false",
maxAge = 4800, allowedHeaders = {"X-Auth-Token", "Content-Type"},
methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.OPTIONS, RequestMethod.DELETE},
origins = "*")
public class CatalogApplicationConfig extends WebMvcConfigurerAdapter {
	
	private static final Logger logger = Logger.getLogger(CatalogApplicationConfig.class);
			
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	logger.info("CORS enabled.");
    	registry.addMapping("/**")
    		.allowedOrigins("*")
    		.allowedMethods("POST", "GET",  "PUT", "OPTIONS", "DELETE")
    		.allowedHeaders("X-Auth-Token", "Content-Type")
    		.allowCredentials(false)
    		.maxAge(4800);
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
    @Bean
    public Docket customImplementation(){
       return new Docket(DocumentationType.SWAGGER_2)
     	  .apiInfo(getApiInfo())	  
     	  .select()
 	  .apis(RequestHandlerSelectors.basePackage("com.proto.catalog.demo"))
 	  .paths(PathSelectors.any())
 	  .build();
    }
    
    @SuppressWarnings("rawtypes")
	private ApiInfo getApiInfo() {
    	return new ApiInfo(
    			"REST Api Documentation", 
    			"REST Api Documentation", 
    			"1.0", 
    			"", 
    			new Contact("", "", ""), 
    			"Apache 2.0", 
    			"", 
    			new ArrayList<VendorExtension>());
     }     
}