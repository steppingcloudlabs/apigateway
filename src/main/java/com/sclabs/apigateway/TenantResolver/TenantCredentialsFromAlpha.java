package com.sclabs.apigateway.TenantResolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sclabs.apigateway.TenantResolver.model.MasterModel;
import com.sclabs.apigateway.TenantResolver.repository.MasterModelRepository;
import com.sclabs.apigateway.TenantResolver.service.MasterService;


@Service
public class TenantCredentialsFromAlpha {
	
	/*
	 * This Class makes connection with Redis and Mongodb of Alpha's database of SteppingCloud.
	 * 
	 */
	
	
	@Autowired
	MasterModelRepository masterModelRepository;
	
	@Autowired
	MasterService myMasterService;
	
	public String getAllCredentials() {
		List<MasterModel> duck = myMasterService.allTenantMasterModels();
		return duck.toString();
	};
	
	public String getTenantAccessDetails(String tenantNameString) {
		
		return tenantNameString;
		
	}
	
	public String getTenantServiceAccessDetials(String tenantName, String serviceName) {
		
		return null;
	}
	
	public String test(String a) {
		return a;
	}

}
