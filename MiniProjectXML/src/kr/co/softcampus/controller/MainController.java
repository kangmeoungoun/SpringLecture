package kr.co.softcampus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.beans.ContentBean;
import kr.co.softcampus.service.MainService;
import kr.co.softcampus.service.TopMenuService;

@Controller
public class MainController {
	 @Autowired
	 private MainService mainService;
	 @Autowired TopMenuService topMenuService;
	 
	@GetMapping("/main")
	public String main(Model model,HttpServletRequest request) {
		ArrayList<List<ContentBean>> list =new ArrayList<List<ContentBean>>();
		
		for (int i = 1; i <=4; i++) {			
			List<ContentBean> list1 = mainService.getMainList(i);
			list.add(list1);
		}
		model.addAttribute("list", list);
		List<BoardInfoBean> board_list = topMenuService.getTopMenuList();
		model.addAttribute("board_list", board_list);
		return "main";
	}
}
