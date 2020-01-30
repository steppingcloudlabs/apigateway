package com.sclabs.apigateway.TenantResolver.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection="servicegods")
@Getter@Setter
public class ServiceGodsModel {
	
	@org.springframework.data.annotation.Id
	ObjectId Id;
	@DBRef
	List<ServicesSchema> service;
	@DBRef
	List<MasterModel> company_oid;
	String username;
	String password;
	Boolean service_status;
	@DBRef
	List<RolesModel> user_role;
	
	
}
