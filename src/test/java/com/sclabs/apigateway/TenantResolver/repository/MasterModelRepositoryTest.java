package com.sclabs.apigateway.TenantResolver.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.netflix.zuul.context.RequestContext;
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

		final List<MasterModel> duck = myMasterService.allTenantMasterModels(null);
		for (final MasterModel masterModel : duck) {
			System.out.println(duck.toString());
		}
	}

}
