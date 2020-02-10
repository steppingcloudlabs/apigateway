package com.sclabs.apigateway.TenantResolver;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bson.types.ObjectId;
import org.eclipse.jgit.transport.CredentialItem.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sclabs.apigateway.TenantResolver.model.MasterModel;
import com.sclabs.apigateway.TenantResolver.model.ServiceGodsModel;

public class TenantResolver extends ZuulFilter {

	@Autowired
	TenantCredentialsFromAlpha child;

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		String companyName = request.getHeader("companyname");
		String serviceName = request.getHeader("servicename");

		List<MasterModel> tenantinfo = child.getTenant(companyName);
		
//		extracting all the tenant information of successfactors.
		ObjectId tenantId = tenantinfo.get(0).getId();
		String tenantDbname = tenantinfo.get(0).getCompany_id();
		String client_id = tenantinfo.get(0).getClient_id();
		String idp_url = tenantinfo.get(0).getIdp_url();
		String token_url = tenantinfo.get(0).getToken_url();
		String private_key = tenantinfo.get(0).getPrivate_key();
		String grant_type = tenantinfo.get(0).getGrant_type();
		
		List<ServiceGodsModel> service = child.getService(tenantId, serviceName);
		
//		service status check
		Boolean serviceStatus = service.get(0).getservice_status();
		if(serviceStatus) {
			String servicename = service.get(0).getService();
			String username = service.get(0).getusername();
			String password = service.get(0).getpassword();
			System.out.println(tenantDbname);
			ctx.addZuulRequestHeader("dbname", tenantDbname);
			ctx.addZuulRequestHeader("clientId", client_id);
			ctx.addZuulRequestHeader("idpUrl", idp_url);
			ctx.addZuulRequestHeader("tokenUrl", token_url);
			ctx.addZuulRequestHeader("privateKey", private_key);
			ctx.addZuulRequestHeader("grantType", grant_type);
			ctx.addZuulRequestHeader("servicename", servicename);
			ctx.addZuulRequestHeader("username", username);
			ctx.addZuulRequestHeader("password", password);
			return ctx;

		} 
		else {
			ctx.setSendZuulResponse(false);
		    ctx.setResponseStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		    ctx.setResponseBody("Service is suspended");
		    ctx.unset();
		    System.out.println("Request Rejected");
		}
		return ctx;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 5;
	}

}
