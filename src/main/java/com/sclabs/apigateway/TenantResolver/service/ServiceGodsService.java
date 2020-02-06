/**
 * 
 */
package com.sclabs.apigateway.TenantResolver.service;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sclabs.apigateway.TenantResolver.model.MasterModel;
import com.sclabs.apigateway.TenantResolver.model.ServiceGodsModel;

/**
 * @author prakritidevvema
 *
 */

@Service
public class ServiceGodsService {
	private MongoTemplate mongoTemplate;

	public ServiceGodsService(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;

	}

	/**
	 * THis function creates a map which
	 * 
	 * @return
	 */
	public List<ServiceGodsModel> getService(ObjectId tenantId, String servicename) {
		
		Query query = new Query().addCriteria(Criteria.where("company_oid").is(tenantId.toString()).andOperator(Criteria.where("service").is(servicename)));
		return mongoTemplate.find(query, ServiceGodsModel.class);

	}

	public ServiceGodsModel getServiceCredentials(String tenantid, String serviceid) {

		return null;

	}

}
