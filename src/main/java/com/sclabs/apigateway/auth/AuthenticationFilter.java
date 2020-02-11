package com.sclabs.apigateway.auth;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AuthenticationFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		RequestContext ctx = RequestContext.getCurrentContext();
		String companyName = ctx.getZuulRequestHeaders().get("dbname");
		String clientId = ctx.getZuulRequestHeaders().get("clientId");
		String idpUrl = ctx.getZuulRequestHeaders().get("username");
		String password = ctx.getZuulRequestHeaders().get("password");
		System.out.println(companyName);
		System.out.println(clientId);
		System.out.println(idpUrl);
		System.out.println(password);
		
		ctx.addZuulResponseHeader("password", password);
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
		return 10;
	}

}
