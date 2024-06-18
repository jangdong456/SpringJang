package com.jang.app.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("student/list")
	public String getList(){
		
		System.out.println("list 입니다~~");
		studentService.getList();
		
		return "student/list";
	}	
	
	@RequestMapping("/student/detail")
	public String getDetail() {
		System.out.println("detail 가져오기");
	
	  return "student/detail";
	}	
}
