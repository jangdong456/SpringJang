package com.jang.app.Student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("student/list")
	public String getList(HttpServletRequest request){
//		request.getParameter("");
		System.out.println("list 입니다~~");
//		studentService.getList();
		
		List<StudentDTO> list = studentService.getList();
		request.setAttribute("list", list);
		
//		"redirect : url"; -> "redirect : /" | 루트로 가겠다.
		return "student/list";
	}	
	
	@RequestMapping("/student/detail")
	public String getDetail() {
		System.out.println("detail 가져오기");
	
	  return "student/detail";
	}	
}
