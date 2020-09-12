package kr.co.softcampus.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.softcampus.beans.UserBean;

@Controller
public class HomeController {
	
	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/main";
	}
}
