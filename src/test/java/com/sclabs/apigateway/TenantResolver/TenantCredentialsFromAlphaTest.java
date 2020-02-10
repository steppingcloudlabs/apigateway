package com.sclabs.apigateway.TenantResolver;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sclabs.apigateway.TenantResolver.model.MasterModel;
import com.sclabs.apigateway.TenantResolver.repository.MasterModelRepository;
import com.sclabs.apigateway.TenantResolver.service.MasterService;

@SpringBootTest
class TenantCredentialsFromAlphaTest {

	@Autowired
	MasterModelRepository masterModelRepository;

	@Autowired
	MasterService myMasterService;

	@Test
	public void getCredentials() {

		System.out.println("Hello World!");

	}

}
