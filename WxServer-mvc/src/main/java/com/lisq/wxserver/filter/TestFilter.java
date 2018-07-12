package com.lisq.wxserver.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class TestFilter implements Filter{
	Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.error("lisq come in!!!");
		chain.doFilter(request, response);
		logger.debug("lisq come out!!!");
	}

	@Override
	public void destroy() {
		
	}
	@Bean
	public FilterRegistrationBean<TestFilter> testFilterRegister(){
		FilterRegistrationBean<TestFilter> filterBean = new FilterRegistrationBean<TestFilter>(this);
		filterBean.addUrlPatterns("/*");
		filterBean.setName("test");
		return filterBean;
	}
}
