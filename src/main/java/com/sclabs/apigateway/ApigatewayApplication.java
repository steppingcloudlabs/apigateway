package com.sclabs.apigateway;


import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.sclabs.apigateway.TenantResolver.TenantResolver;
import com.sclabs.apigateway.auth.Authentication;
import com.sclabs.apigateway.auth.AuthenticationFilter;
import com.sclabs.apigateway.errorfilter.ErrorFilter;
import com.sclabs.apigateway.postfilter.PostFilter;
import com.sclabs.apigateway.prefilter.PreFilter;
import com.sclabs.apigateway.routefilter.RouteFilter;

import io.github.kaiso.relmongo.config.EnableRelationalMongo;


@SpringBootApplication
@EnableZuulProxy
@EnableRelationalMongo
public class ApigatewayApplication {
	private static final Logger LOG = LoggerFactory.getLogger("SCLABS");

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}
//	@Bean
//    public PreFilter preFilter() {
//        return new PreFilter();
//    }
//	@Bean
//	public PostFilter postFilter() {
//		return new PostFilter();
//	}
//	@Bean
//	public RouteFilter routeFilter() {
//		return new RouteFilter();
//	}
//	@Bean
//	public ErrorFilter errorFilter() {
//		return new ErrorFilter();
//	}
	
	@Bean
	public TenantResolver tenantResolver() {
		return new TenantResolver();
	}
	@Bean
	public AuthenticationFilter authenticationFilter() {
		return new AuthenticationFilter();
	}
}
