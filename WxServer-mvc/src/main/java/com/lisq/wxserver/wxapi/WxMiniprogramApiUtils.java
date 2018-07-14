package com.lisq.wxserver.wxapi;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.lisq.wxserver.conf.WxServerConfig;
import com.lisq.wxserver.exception.BusinessException;
import com.lisq.wxserver.pub.WxjsonUtils;
import com.lisq.wxserver.utils.HttpClientUtil;

/**
 * 微信小程序API
 * 
 * @author lisq
 * @date 2018年7月14日
 */
@Configuration
public class WxMiniprogramApiUtils {
	
	public WxMiniprogramApiUtils() {
		
	}
	@Autowired
	private WxServerConfig wxServerConfig;
	/**
	 * 执行小程序后端认证
	 * @return Map<String,String> 
	 * @author lisq
	 * @date 2018年7月14日
	 */
	public HashMap<String,String> doWxApilogin(String requestCode) throws BusinessException{
		String url = getWxServerConfig().getWxsessionurl()+"?&grant_type=authorization_code&appid="+getWxServerConfig().getAppid()
				+"&secret"+getWxServerConfig().getAppsecret()+"&js_code="+requestCode;
		String result =  HttpClientUtil.doHttpGet(url, null);
		return WxjsonUtils.toJavaObject(result, HashMap.class);
	}
	public WxServerConfig getWxServerConfig() {
		return wxServerConfig;
	}
	public void setWxServerConfig(WxServerConfig wxServerConfig) {
		this.wxServerConfig = wxServerConfig;
	}
	
	
}
