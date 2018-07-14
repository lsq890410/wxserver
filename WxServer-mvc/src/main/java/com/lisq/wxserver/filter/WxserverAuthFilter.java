package com.lisq.wxserver.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.lisq.wxserver.conf.WxServerConfig;
import com.lisq.wxserver.exception.PlatFormException;
import com.lisq.wxserver.pub.IWxserverConstance;
import com.lisq.wxserver.pub.WxClientUtils;
import com.lisq.wxserver.pub.WxjsonUtils;

/**
 * 小程序的权限控制
 * 
 * @author lisq
 * @date 2018年7月14日
 */
@Configuration
public class WxserverAuthFilter implements Filter,IWxserverConstance{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private WxServerConfig wxServerConfig;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		try {
			// 1. 安全认证
			doAuthCheck(httpRequest);
			// 2. 功能权限认证
			doFuncCheck(httpRequest);
			// 3. 资源权限认证
			doResCheck(httpRequest);
		} catch (Exception e) {
			logger.error("认证失败："+e.getMessage(),e);
			response.getOutputStream().write(WxjsonUtils.toJSONString(WxClientUtils.getFailjson("认证失败："+e.getMessage())).getBytes());
			response.getOutputStream().flush();
			response.getOutputStream().close();
			return;
		}
		try {
			chain.doFilter(request, response);
		}catch(Throwable e) {
			logger.error("请求失败："+e.getMessage(),e);
			response.getOutputStream().write(WxjsonUtils.toJSONString(WxClientUtils.getFailjson("请求失败："+e.getMessage())).getBytes());
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
	}
	
	private void doAuthCheck(HttpServletRequest httpRequest ) throws PlatFormException{
		String skey = httpRequest.getHeader(__S_SKEY);
		if(StringUtils.isEmpty(skey) || !skey.equals(wxServerConfig.getSkey())) {
			throw new PlatFormException("小程序认证失败：检查skey是否正确！！！");
		}
	}
	
	private void doFuncCheck(HttpServletRequest httpRequest )throws PlatFormException{
		//TODO
	}
	
	private void doResCheck(HttpServletRequest httpRequest )throws PlatFormException{
		//TODO
	}

	@Override
	public void destroy() {
		
	}
	@Bean
	public FilterRegistrationBean<WxserverAuthFilter> testFilterRegister(){
		FilterRegistrationBean<WxserverAuthFilter> filterBean = new FilterRegistrationBean<WxserverAuthFilter>(this);
		filterBean.addUrlPatterns("/*");
		filterBean.setName("auth");
		return filterBean;
	}

	public WxServerConfig getWxServerConfig() {
		return wxServerConfig;
	}

	public void setWxServerConfig(WxServerConfig wxServerConfig) {
		this.wxServerConfig = wxServerConfig;
	}
}
