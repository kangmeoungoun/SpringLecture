package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softcampus.beans.DataBean;

@Controller
public class TestController {
	@PostMapping(value = "/test1")
	// public String test1(@ModelAttribute DataBean bean) {
	public String test1(DataBean bean) {
		// System.out.printf("data1 : %s\n",bean.getData1());
		// System.out.printf("data2 : %s\n",bean.getData2());
		System.out.println("!!!!");
		System.out.println("hello dance world");
		System.out.println("@@@####");
		return "test1";
	}

	@PostMapping(value = "/test2")
	public String test(@ModelAttribute("testData") DataBean bean) {
		return "test2";
	}
}
