package com.sclabs.apigateway.TenantResolver.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.sclabs.apigateway.TenantResolver.model.MasterModel;
import com.sclabs.apigateway.TenantResolver.model.ServiceGodsModel;
import com.sclabs.apigateway.TenantResolver.model.ServicesSchema;

@Service
public class MasterService {
	private final MongoTemplate mongoTemplate;

	public MasterService(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;

	}

	public List<MasterModel> getTenant(String companyName) {
		Query query = new Query().addCriteria(Criteria.where("company_name").is(companyName));
		return mongoTemplate.find(query, MasterModel.class);
	}

}
