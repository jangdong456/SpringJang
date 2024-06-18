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
}
