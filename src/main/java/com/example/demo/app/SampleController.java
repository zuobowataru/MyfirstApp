package com.example.demo.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SampleController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		String sql ="Select id, name, email "
				    + "From inquiry where id = 2";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
		
		model.addAttribute("title","Inquiry For Form");
		model.addAttribute("name",map.get("name"));
		model.addAttribute("email",map.get("email"));

		return"test";
	}
}


