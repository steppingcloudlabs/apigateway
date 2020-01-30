package com.sclabs.apigateway.TenantResolver.model;


import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Document(collection="masters")
public class MasterModel {
	
	@Id
	ObjectId Id;
	String company_id;
	String company_name;
	String client_id;
	String idp_url;
	String token_url;
	String private_key;
	String grant_type;
	String company_admin_contact_email;
	String master_username;
	String master_password;
	@DBRef
	List<ObjectId> service_name;
	public ObjectId getId() {
		return Id;
	}
	public void setId(ObjectId id) {
		Id = id;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getIdp_url() {
		return idp_url;
	}
	public void setIdp_url(String idp_url) {
		this.idp_url = idp_url;
	}
	public String getToken_url() {
		return token_url;
	}
	public void setToken_url(String token_url) {
		this.token_url = token_url;
	}
	public String getPrivate_key() {
		return private_key;
	}
	public void setPrivate_key(String private_key) {
		this.private_key = private_key;
	}
	public String getGrant_type() {
		return grant_type;
	}
	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}
	public String getCompany_admin_contact_email() {
		return company_admin_contact_email;
	}
	public void setCompany_admin_contact_email(String company_admin_contact_email) {
		this.company_admin_contact_email = company_admin_contact_email;
	}
	public String getMaster_username() {
		return master_username;
	}
	public void setMaster_username(String master_username) {
		this.master_username = master_username;
	}
	public String getMaster_password() {
		return master_password;
	}
	public void setMaster_password(String master_password) {
		this.master_password = master_password;
	}
	public List<ObjectId> getService_name() {
		return service_name;
	}
	public void setService_name(List<ObjectId> service_name) {
		this.service_name = service_name;
	}
	@Override
	public String toString() {
		return "MasterModel [Id=" + Id + ", company_id=" + company_id + ", company_name=" + company_name
				+ ", client_id=" + client_id + ", idp_url=" + idp_url + ", token_url=" + token_url + ", private_key="
				+ private_key + ", grant_type=" + grant_type + ", company_admin_contact_email="
				+ company_admin_contact_email + ", master_username=" + master_username + ", master_password="
				+ master_password + ", service_name=" + service_name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((client_id == null) ? 0 : client_id.hashCode());
		result = prime * result + ((company_admin_contact_email == null) ? 0 : company_admin_contact_email.hashCode());
		result = prime * result + ((company_id == null) ? 0 : company_id.hashCode());
		result = prime * result + ((company_name == null) ? 0 : company_name.hashCode());
		result = prime * result + ((grant_type == null) ? 0 : grant_type.hashCode());
		result = prime * result + ((idp_url == null) ? 0 : idp_url.hashCode());
		result = prime * result + ((master_password == null) ? 0 : master_password.hashCode());
		result = prime * result + ((master_username == null) ? 0 : master_username.hashCode());
		result = prime * result + ((private_key == null) ? 0 : private_key.hashCode());
		result = prime * result + ((service_name == null) ? 0 : service_name.hashCode());
		result = prime * result + ((token_url == null) ? 0 : token_url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MasterModel other = (MasterModel) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (client_id == null) {
			if (other.client_id != null)
				return false;
		} else if (!client_id.equals(other.client_id))
			return false;
		if (company_admin_contact_email == null) {
			if (other.company_admin_contact_email != null)
				return false;
		} else if (!company_admin_contact_email.equals(other.company_admin_contact_email))
			return false;
		if (company_id == null) {
			if (other.company_id != null)
				return false;
		} else if (!company_id.equals(other.company_id))
			return false;
		if (company_name == null) {
			if (other.company_name != null)
				return false;
		} else if (!company_name.equals(other.company_name))
			return false;
		if (grant_type == null) {
			if (other.grant_type != null)
				return false;
		} else if (!grant_type.equals(other.grant_type))
			return false;
		if (idp_url == null) {
			if (other.idp_url != null)
				return false;
		} else if (!idp_url.equals(other.idp_url))
			return false;
		if (master_password == null) {
			if (other.master_password != null)
				return false;
		} else if (!master_password.equals(other.master_password))
			return false;
		if (master_username == null) {
			if (other.master_username != null)
				return false;
		} else if (!master_username.equals(other.master_username))
			return false;
		if (private_key == null) {
			if (other.private_key != null)
				return false;
		} else if (!private_key.equals(other.private_key))
			return false;
		if (service_name == null) {
			if (other.service_name != null)
				return false;
		} else if (!service_name.equals(other.service_name))
			return false;
		if (token_url == null) {
			if (other.token_url != null)
				return false;
		} else if (!token_url.equals(other.token_url))
			return false;
		return true;
	}
	
	
	

}
