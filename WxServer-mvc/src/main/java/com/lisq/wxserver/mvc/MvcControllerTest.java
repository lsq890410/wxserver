package com.lisq.wxserver.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MvcControllerTest {
	@RequestMapping("/test2")
	@ResponseBody
	String home(HttpServletRequest request) {
		return "Hello World!"+request.getParameter("user");
	}

}
