package com.sclabs.apigateway.TenantResolver.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sclabs.apigateway.TenantResolver.model.MasterModel;
import com.sclabs.apigateway.TenantResolver.service.MasterService;

@SpringBootTest
class MasterModelRepositoryTest {

	@Autowired
	MasterModelRepository masterModelRepository;
	
	@Autowired
	MasterService myMasterService;
	
	@Test
	public void test() {
		System.out.println("Fucking");
		List<MasterModel> duck = myMasterService.allTenantMasterModels();
		for (MasterModel masterModel : duck) {
			System.out.println(duck.toString());
		}
	}
	
}
