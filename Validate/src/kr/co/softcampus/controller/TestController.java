package kr.co.softcampus.controller;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softcampus.beans.DataBean1;

@Controller
public class TestController {
	
	@GetMapping("/input_data")
	public String input_data() {	
		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String input_pro(@Valid DataBean1 dataBean1 , BindingResult result) {
		
		System.out.printf("data1 : %s\n",dataBean1.getData1());
		System.out.printf("data2 : %s\n",dataBean1.getData2());
		//System.out.printf("bindingResult %s\n",result);
		//유효성 검사에서 위반된 부분이 있다면..
		if(result.hasErrors()) {
			//유효성 위반 결과를 모두 가져온다.
			for(ObjectError obj :result.getAllErrors() ) {
				System.out.printf("메시지 : %s\n",obj.getDefaultMessage());
				System.out.printf("code : %s\n",obj.getCode());
				System.out.printf("object name  : %s\n",obj.getObjectName());
				String [] codes = obj.getCodes();
				for(String c1 : codes) {
					System.out.println(c1);
				}
				System.out.println("------------------------");
				if(codes[0].equals("Size.dataBean1.data1")) {
					System.out.println("data1 은 2 ~ 10 글자를 담을수 있습니다.");
				}else if(codes[0].equals("Max.dataBean1.data2")) {
					System.out.println("data2 은 100 이하의 값만 들어갈수 있습니다.");
				}
			}
			return "input_data";
		}
		return "input_success";
	}
}
