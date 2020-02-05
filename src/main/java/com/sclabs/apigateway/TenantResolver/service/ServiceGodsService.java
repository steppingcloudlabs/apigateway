/**
 * 
 */
package com.sclabs.apigateway.TenantResolver.service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.sclabs.apigateway.TenantResolver.model.MasterModel;
import com.sclabs.apigateway.TenantResolver.model.ServiceGodsModel;

/**
 * @author prakritidevvema
 *
 */

@Service
public class ServiceGodsService {
	private final MongoTemplate mongoTemplate;

	public ServiceGodsService(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;

	}
	
	/**
	 * THis function creates a map which
	 * @return
	 */
	public ServiceGodsModel getService() {
		
		return null;
		
	}
	public ServiceGodsModel getServiceCredentials(String tenantid, String serviceid) {
		
		return null;
		
	}
	
	
}
