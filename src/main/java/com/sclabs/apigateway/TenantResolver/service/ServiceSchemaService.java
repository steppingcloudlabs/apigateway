package com.sclabs.apigateway.TenantResolver.service;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.sclabs.apigateway.TenantResolver.model.ServiceGodsModel;

public class ServiceSchemaService {
	
	private final MongoTemplate mongoTemplate;

	public ServiceSchemaService(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;

	}
	
	public List<ServiceSchemaService> getService(String servicename) {
		Query query = new Query().addCriteria(Criteria.where("service_name").is(servicename));
		return mongoTemplate.find(query, ServiceSchemaService.class);

	} 

}
