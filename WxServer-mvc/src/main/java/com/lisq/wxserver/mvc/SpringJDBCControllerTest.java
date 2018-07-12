package com.lisq.wxserver.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class SpringJDBCControllerTest {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@GetMapping("/id")
	@ResponseBody
	public String getUserVOList(@RequestParam(name="id") String userid){
		String sql = "select userid from lcwx_user";
		logger.error("lisq say hello!!!"
				+ "");
		return getJdbcTemplate().queryForObject(sql, String.class);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
