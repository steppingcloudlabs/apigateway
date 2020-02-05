package com.sclabs.apigateway.TenantResolver;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sclabs.apigateway.TenantResolver.model.MasterModel;

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

		List<MasterModel> duck = child.getTenant(companyName);
		
		System.out.println(duck.get(0).getService_name());
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 2;
	}

}
