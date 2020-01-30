package com.sclabs.apigateway.TenantResolver.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Document(collection="services")
public class ServicesSchema {
	
	@Id
	String id;
	String service_name;
	@DBRef
	List<MasterModel> tenant_id;

}
