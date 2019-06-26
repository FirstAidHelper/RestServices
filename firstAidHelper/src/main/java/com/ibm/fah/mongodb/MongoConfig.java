package com.ibm.fah.mongodb;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoConfig {

	@Value("${spring.data.mongodb.database}")
	private String database;

	@Value("${spring.data.mongodb.uri}")
	private String uri;

	@Bean
	public MongoTemplate mongoTemplate() throws IOException {
		MongoClient client = new MongoClient(new MongoClientURI(uri));
		return new MongoTemplate(client, database);
	}
}
