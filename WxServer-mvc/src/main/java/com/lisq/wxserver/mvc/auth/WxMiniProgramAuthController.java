package com.lisq.wxserver.mvc.auth;


import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lisq.wxserver.exception.BusinessException;
import com.lisq.wxserver.mvc.service.WxMiniProgramAuthService;
import com.lisq.wxserver.pub.IWxserverConstance;
import com.lisq.wxserver.wxapi.WxMiniprogramApiUtils;

@Controller
@RequestMapping("/auth")
@Validated
public class WxMiniProgramAuthController implements IWxserverConstance{
	@Autowired
	private WxMiniprogramApiUtils wxMiniProgramUtils;
	@Autowired
	private WxMiniProgramAuthService service;
	/**
	 * 执行微信小程序的登陆
	 * @return String 
	 * @author lisq
	 * @date 2018年7月14日
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String doWxMiniProgramLogin(@NotNull @RequestParam(name="code") String code)throws BusinessException {
		//1. 调用微信api
		Map<String,String> wxResult = wxMiniProgramUtils.doWxApilogin(code);
		//2. 对结果进行分析
		if(StringUtils.isEmpty(wxResult.get(__S_APPID))) {
			//成功：新增用户，并返回appsession
			return service.doLogin(wxResult);
		} else {
			//失败：返回失败信息
			throw new BusinessException("微信API请求发生异常："+wxResult.get("errcode")+","+wxResult.get("errormsg"));
		}
	}
}
