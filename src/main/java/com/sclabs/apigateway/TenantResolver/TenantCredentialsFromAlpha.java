package com.sclabs.apigateway.TenantResolver;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.sclabs.apigateway.TenantResolver.model.MasterModel;
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

	public List<MasterModel> getAllCredentials(String Companyname) {

		final List<MasterModel> duck = myMasterService.getTenantAccessDetails(Companyname);
		return duck;
	};

	public String getTenantAccessDetails(final String tenantNameString) {

		return tenantNameString;

	}

	public String getTenantServiceAccessDetials(final String tenantName, final String serviceName) {

		return null;
	}

	public String test(final String a) {
		return a;
	}

}
