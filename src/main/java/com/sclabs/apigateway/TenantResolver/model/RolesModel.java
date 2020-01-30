package com.sclabs.apigateway.TenantResolver.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection="roles")
@Getter@Setter
public class RolesModel {
	
	@org.springframework.data.annotation.Id
	ObjectId Id;
	@DBRef
	List<String> permission;
	String role;
}
