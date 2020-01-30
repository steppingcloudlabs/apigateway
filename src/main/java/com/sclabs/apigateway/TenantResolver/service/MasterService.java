package com.sclabs.apigateway.TenantResolver.service;

import java.util.List;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.sclabs.apigateway.TenantResolver.model.MasterModel;

@Service
public class MasterService {
	private final MongoTemplate mongoTemplate;
	
	public MasterService(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
		
	}
	public List<MasterModel> allTenantMasterModels(){
		Query query = new Query()
				.addCriteria(Criteria.where("company_name").is("salesdemo"));
		return mongoTemplate.find(query, MasterModel.class);
	}
	
}
