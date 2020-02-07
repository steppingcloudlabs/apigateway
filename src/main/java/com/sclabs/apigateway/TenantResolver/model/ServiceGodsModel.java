package com.sclabs.apigateway.TenantResolver.model;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "servicegods")
@Getter
@Setter
public class ServiceGodsModel {

	@Id
	ObjectId Id;
	String service;
	ObjectId company_oid;
	String username;
	String password;
	Boolean service_status;
	

	List<ObjectId> user_role;

	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	public ObjectId getId() {
		return Id;
	}

	public void setId(final ObjectId id) {
		Id = id;
	}

	@JsonSerialize(using = ToStringSerializer.class)
	public String getService() {
		return service;
	}

	public void setService(final String service) {
		this.service = service;
	}

	@JsonSerialize(using = ToStringSerializer.class)
	public ObjectId getCompany() {
		return company_oid;
	}

	public void setCompany(final ObjectId company_oid) {
		this.company_oid = company_oid;
	}

	public String getusername() {
		return username;
	}

	public void setusername(final String username) {
		this.username = username;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(final String password) {
		this.password = password;
	}

	public Boolean getservice_status() {
		return service_status;
	}

	public void setservice_status(final Boolean service_status) {
		this.service_status = service_status;
	}

	@JsonSerialize(using = ToStringSerializer.class)
	public List<ObjectId> getuser_role() {
		return user_role;
	}

	public void setuser_role(final List<ObjectId> user_role) {
		this.user_role = user_role;
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
