package kr.co.softcampus.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softcampus.beans.DataBean;

@Controller
public class TestController {
	@Autowired
	SqlSessionTemplate SqlsessionTemplate;
	
	@GetMapping("/input_data")
	public String input_data() {
		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String input_pro(DataBean dataBean) {
		SqlsessionTemplate.insert("test_db.insert_data", dataBean);
		return "input_pro";
	}
	
	@GetMapping("/read_data")
	public String read_data(Model model) {
		List<DataBean> list = SqlsessionTemplate.selectList("test_db.select_data");
		model.addAttribute("list",list);
		return "read_data";
	}
}
