package com.proto.catalog.resource.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.proto.demo.config.CoreConfig;

@SpringBootApplication(scanBasePackages = "com.proto.catalog.demo")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
@Import(value = {CoreConfig.class})
public class CatalogResourceServer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CatalogResourceServer.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(CatalogResourceServer.class, args);
    }

}
