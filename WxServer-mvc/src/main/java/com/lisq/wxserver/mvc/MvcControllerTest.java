package com.lisq.wxserver.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MvcControllerTest {
	@RequestMapping("/test2")
	@ResponseBody
	String home(@RequestParam(name="user") String user) {
		return "Hello World!"+user;
	}

}
