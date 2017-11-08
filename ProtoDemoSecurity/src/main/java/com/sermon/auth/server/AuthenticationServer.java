package com.sermon.auth.server;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class AuthenticationServer extends SpringBootServletInitializer {
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AuthenticationServer.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(AuthenticationServer.class, args);
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        System.out.println("AS /user has been called");
        System.out.println("user info: " + user.toString());
        return user;
    }
}