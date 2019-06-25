package com.ibm.fah.mongodb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MongoConfig {
	@Value("${spring.data.mongodb.database}")
	private String database;
	@Value("${spring.data.mongodb.host}")
	private String host;
	@Value("${spring.data.mongodb.port}")
	private String port;
	@Value("${spring.data.mongodb.username}")
	private String username;
	@Value("${spring.data.mongodb..password}")
	private String password;

	@Bean
	public MongoTemplate mongoTemplate() throws IOException {
		List<MongoCredential> allCred = new ArrayList<MongoCredential>();
		System.out
				.println("???????????????????" + username + " " + database + " " + password + " " + host + " " + port);
		allCred.add(MongoCredential.createCredential(username, database, password.toCharArray()));
		MongoClient client = new MongoClient(new ServerAddress(host, Integer.parseInt(port)), allCred);
		return new MongoTemplate(client, database);
	}
}
