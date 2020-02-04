package com.sclabs.apigateway.TenantResolver;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
		// ObjectMapper Obj = new ObjectMapper();
		// Obj.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
		// Obj.enable(SerializationFeature.INDENT_OUTPUT);
		// Gson gson = new Gson();

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		String companyName = request.getHeader("companyname");
		String serviceName = request.getHeader("servicename");

		List<MasterModel> duck = child.getAllCredentials(companyName);

		System.out.println(duck);
		// String numbersJson = gson.toJson(duck);
		// System.out.print(numbersJson);

		// String jsonStr;
		// try {
		// jsonStr = Obj.readValue(duck);
		// System.out.print(jsonStr);

		// } catch (final JsonProcessingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

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
