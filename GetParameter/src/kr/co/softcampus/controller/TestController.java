package kr.co.softcampus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TestController {
	@GetMapping(value = "/test1")
	public String test1(HttpServletRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");
		System.out.printf("data1 %s\n", data1);
		System.out.printf("data2 %s\n", data2);
		for (String str1 : data3) {
			System.out.printf("data3 %s\n", str1);
		}
		return "result";
	}

	@PostMapping(value = "/test2")
	public String test2(HttpServletRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");
		System.out.printf("data1 %s\n", data1);
		System.out.printf("data2 %s\n", data2);
		if (data3 != null) {
			for (String str1 : data3) {
				System.out.printf("data3 %s\n", str1);
			}
		}
		return "result";
	}

	@GetMapping(value ="/test3")
	public String test3(WebRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");
		System.out.printf("data1 %s\n", data1);
		System.out.printf("data2 %s\n", data2);

		for (String str1 : data3) {
			System.out.printf("data3 %s\n", str1);
		}

		return "result";
	}
	
	
	@GetMapping(value = "/test4/{data1}/{data2}/{data3}")
	public String test4(@PathVariable String data1,
			            @PathVariable String data2,
			            @PathVariable int data3
			            ) {
		System.out.printf("data1 %s\n", data1);
		System.out.printf("data2 %s\n", data2);
		System.out.printf("data3 %d\n", data3);
		
		return "result";
	}
	@GetMapping(value ="/test5")
	public String test5(@RequestParam int data1,
			            @RequestParam int data2,
			            @RequestParam int [] data3	
			) {
		System.out.println("test5");
		System.out.printf("data1 %d\n", data1);
		System.out.printf("data2 %d\n", data2);
		for(int a1 : data3) {
			System.out.printf("data3 %d\n", a1);
		}
		return "result";
	}
	
	@GetMapping(value ="/test6")
	public String test6( @RequestParam(value ="data1") int value1,
			             @RequestParam(value ="data2") int value2,
			             @RequestParam(value ="data3") int [] value3
			) {
		System.out.println("test6");
		System.out.printf("data1 %d\n", value1);
		System.out.printf("data2 %d\n", value2);
		for(int a1 : value3) {
			System.out.printf("data3 %d\n", a1);
		}
		return "result";
	}
	@GetMapping(value="/test7")
	public String test7(@RequestParam int data1
			           ,@RequestParam(required = false) String data2
			           ,@RequestParam(defaultValue = "0") int data3) { //data2 라는 파라미터를 보내지 않아도 null으로 주입하게 
		               
		System.out.println("data1 : "+data1);
		System.out.println("data2 : "+data2);
		System.out.println("data3 : "+data3);
		return "result";
	}

}