package com.sclabs.apigateway.TenantResolver;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.sclabs.apigateway.TenantResolver.model.MasterModel;
import com.sclabs.apigateway.TenantResolver.model.ServiceGodsModel;
import com.sclabs.apigateway.TenantResolver.repository.MasterModelRepository;
import com.sclabs.apigateway.TenantResolver.service.MasterService;

@Service
public class TenantCredentialsFromAlpha {

	/*
	 * This Class makes connection with Redis and Mongodb of Alpha's database of
	 * SteppingCloud.
	 * 
	 */

	@Autowired
	MasterModelRepository masterModelRepository;

	@Autowired
	MasterService myMasterService;

	public List<MasterModel> getTenant(String Companyname) {

		final List<MasterModel> duck = myMasterService.getTenant(Companyname);
		return duck;
	};
	public List<ServiceGodsModel> getAllService(){
		/**
		 * 1. Create a map that will store all the objectIds of ServicesGods for all tenants.
		 * 2. If values is not in map? fetch it from redis. If its not in redis then get it from mongodb and updated redis as well. 
		 * 3. If value is in map -> use it. 
		 */
		
		return null;
		
	}
	public List<ServiceGodsModel> getServiceCredentials(String name, ObjectId mongoId){
		
		/**
		 * 1. If serviceName exists? Then lookup in map created by  getAllService(). 
		 * 2. If mongoId exists in map. Then get the data of that service from from redis.
		 * 3. If not in redis, then get it from mongodb and updated redis.
		 * 4. return credentials. 
		 */
		
		return null;
		
	}

}
