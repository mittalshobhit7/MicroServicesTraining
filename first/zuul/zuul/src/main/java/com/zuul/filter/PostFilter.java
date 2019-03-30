package com.zuul.filter;

import com.netflix.zuul.ZuulFilter;

public class PostFilter extends ZuulFilter{
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
	
@Override
public Object run(){
System.out.println("post filter");
return null;
}
	
}