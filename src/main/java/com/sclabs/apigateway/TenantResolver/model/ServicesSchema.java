package com.sclabs.apigateway.TenantResolver.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import io.github.kaiso.relmongo.annotation.*;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Document(collection = "services")

public class ServicesSchema {

	@Id
	String id;
	String service_name;
	@DBRef
	List<MasterModel> tenant_id;

	// ObjectMapper Obj = new ObjectMapper();

	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	@JsonSerialize(using = ToStringSerializer.class)
	public List<MasterModel> getTenant_id() {
		return tenant_id;
	}

	public void setTenant_id(List<MasterModel> tenant_id) {
		this.tenant_id = tenant_id;
	}

	@Override
	public String toString() {
		try {
			return new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter()
					.writeValueAsString(this);
		} catch (final com.fasterxml.jackson.core.JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
