package com.sclabs.apigateway.TenantResolver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sclabs.apigateway.TenantResolver.model.MasterModel;


public interface MasterModelRepository extends MongoRepository<MasterModel, String> {
	
}
