package com.vega.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class ApplicationConfig extends AbstractMongoConfiguration{
	@Override
	protected String getDatabaseName() {
		return "GridDB";
	}
	
	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1");
	}
	
	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception{
		return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
	}

}
