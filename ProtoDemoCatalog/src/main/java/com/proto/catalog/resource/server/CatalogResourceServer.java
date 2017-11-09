package com.proto.catalog.resource.server;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proto.catalog.main.config.CatalogApplicationConfig;
import com.proto.demo.config.CoreConfig;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*
@SpringBootApplication(scanBasePackages = "com.proto.catalog.demo")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
@CrossOrigin(allowCredentials = "false",
maxAge = 4800, allowedHeaders = {"X-Auth-Token", "Content-Type"},
methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.OPTIONS, RequestMethod.DELETE},
origins = "*")
*/
public class CatalogResourceServer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CatalogApplicationConfig.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(CatalogApplicationConfig.class, args);
    }
}
