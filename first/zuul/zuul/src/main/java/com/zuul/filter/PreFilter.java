package com.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PreFilter extends ZuulFilter{
	@Override
	public String filterType(){
		return "pre";
	}
	
	@Override
	public int filterOrder(){
		return 0;
	}
	
	@Override
	public boolean shouldFilter(){
		return true;
	}
	
//	@Override
//	public Object run(){
//		System.out.println("Prefileter");
//		return null;
//	}
	
	@Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        
        System.out.println("Request Method : " + request.getMethod() + "Request URL : " + request.getRequestURL().toString()) ;
        return null;
    }
	
}
