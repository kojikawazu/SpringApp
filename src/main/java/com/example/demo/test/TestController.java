package com.example.demo.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class TestController {

	@GetMapping("/test")
	public String Test(Model model) {
		model.addAttribute("title", "Sample Home...");
	
		return "test/test";
		
	}
}
