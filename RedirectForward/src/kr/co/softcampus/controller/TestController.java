package kr.co.softcampus.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		System.out.println("test1 "+request);
		return "redirect:/sub1";
	}
	@GetMapping("/sub1")
	public String sub1(HttpServletRequest request) {
		System.out.println("sub1 "+request);
		return "sub1";
	}
	@GetMapping("/test2")
	public String test2(HttpServletRequest request) {
		System.out.println("test2 "+request);
		return "forward:/sub2";
	}
	@GetMapping("/sub2")
	public String sub2(HttpServletRequest request) {
		System.out.println("sub2 "+request);
		return "sub2";
	}

}
