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
import com.sclabs.apigateway.TenantResolver.service.ServiceGodsService;

/*
 * This Class makes connection with Redis and Mongodb of Alpha's mongodb database.
 * 
 */
@Service
public class TenantCredentialsFromAlpha {

	@Autowired
	MasterModelRepository masterModelRepository;

	@Autowired
	MasterService myMasterService;

	@Autowired
	ServiceGodsService serviceService;

	@Autowired
	ServiceGodsService serviceGodsService;

	/**
	 * This function expects company name as a string and returns the document with
	 * all SF credentials.
	 * 
	 * @param Companyname
	 * @return tenant
	 */
	public List<MasterModel> getTenant(String Companyname) {
		/**
		 * 
		 */
		final List<MasterModel> tenant = myMasterService.getTenant(Companyname);
		return tenant;
	};

	/**
	 * This function creates a map that stores all the objectIds of ServicesGods for
	 * all tenants. If values is not in map, fetch it from redis. If its not in
	 * redis then get it from mongodb and updated redis as well.
	 * 
	 * If value is in map then pass.
	 * 
	 * @return _id
	 */
	public List<ServiceGodsModel> getService() {
		/**
		 *
		 */
		final List<ServiceGodsModel> tenant2 = serviceService.getService();
		return tenant2;

	}

	/**
	 * This function fetch the credentials of serviceGods.
	 * 
	 * @param tenantid
	 * @param serviceid
	 * @return document
	 */
	public List<ServiceGodsModel> getServiceCredentials(String tenantid, ObjectId serviceid) {

		/**
		 * 1. If serviceName exists? Then lookup in map created by getAllService(). 2.
		 * If mongoId exists in map. Then get the data of that service from from redis.
		 * 3. If not in redis, then get it from mongodb and updated redis. 4. return
		 * credentials.
		 */

		return null;

	}

}
