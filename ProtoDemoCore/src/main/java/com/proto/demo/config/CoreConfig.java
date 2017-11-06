package com.proto.demo.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
@ComponentScan(basePackages = "com.proto.demo")
@PropertySource("classpath:application.properties")
public class CoreConfig {
	
	private static final Logger logger = Logger.getLogger(CoreConfig.class);
	
	@Value("${proto.demo.mongo.host}")
	private String mongoHost;
	
	@Value("${proto.demo.mongo.port}")
	private Integer mongoPort;
	
	@Value("${proto.demo.mongo.database}")
	private String mongoDb;
	
	@Value("${proto.demo.mongo.user}")
	private String mongoUser;
	
	@Value("${proto.demo.mongo.pwd}")
	private String mongoPwd;
	
    @SuppressWarnings("deprecation")
	@Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
    	logger.info("----------------------------------------------------");
    	logger.info("mongo info :");
    	logger.info("host : " + mongoHost);
    	logger.info("port : " + mongoPort);
    	logger.info("db   : " + mongoDb);
    	logger.info("user : " + mongoUser);
    	
        MongoClient mongoClient = new MongoClient(mongoHost, mongoPort);
        UserCredentials userCredentials = new UserCredentials(mongoUser, mongoPwd);
        return new SimpleMongoDbFactory(mongoClient, mongoDb, userCredentials);
    }
 
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
    

}
