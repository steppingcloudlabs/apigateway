package com.sclabs.apigateway.config;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;


@Configuration
public class MongoConfig {
	
	@Autowired
	Environment env;
	
	public @Bean MongoDbFactory mongoDbFactory() throws Exception {
	    UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(env.getProperty("db.username"), env.getProperty("db.password"));
	    return new SimpleMongoDbFactory(new MongoClient(env.getProperty("db.host"), env.getProperty("db.port",Integer.class, 27017)), env.getProperty("db.name"));
	}

	public @Bean MongoTemplate mongoTemplate() throws Exception {
	    return new MongoTemplate(mongoDbFactory());
	}
}
