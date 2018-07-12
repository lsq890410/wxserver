package com.lisq.wxserver.mvc;

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
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@GetMapping("/id")
	@ResponseBody
	public String getUserVOList(@RequestParam(name="id") String userid){
		String sql = "select userid from lcwx_user";
		return getJdbcTemplate().queryForObject(sql, String.class);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
