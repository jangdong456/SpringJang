package com.jang.app.Student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jang.app.weather.WeatherDTO;

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
	
	@RequestMapping("/student/add")
	public String add(HttpServletRequest request) {
		
		// 여기에 return문은 jsp로 보내는 경로이다. 
		// WEB-INF/views/student/add.jsp
		
		return"/student/add";
	}	
	
	@RequestMapping(value = "/student/add" , method = RequestMethod.POST)
	public String add2(HttpServletRequest request) {
		StudentDTO stdto = new StudentDTO();
		stdto.setCity(request.getParameter("city"));
		stdto.setGion(Double.parseDouble(request.getParameter("gion")));
		stdto.setStatus(request.getParameter("Status"));
		stdto.setHuminity(Integer.parseInt(request.getParameter("huminity")));
											
		studentService.add(stdto);
		return "redirect:/student/list";
	} 
	
	
	@RequestMapping("/student/detail")
	public String getDetail(HttpServletRequest request) {
		String num = request.getParameter("num");
		StudentDTO stdto = new StudentDTO();
		
		stdto.setNum(Integer.parseInt(num));
		stdto = studentService.getDetail(stdto);
		
		if(stdto != null) {
			request.setAttribute("dto", stdto);
		}else {
			System.out.println("해당값을 불러오지 못했습니다");
		}
		return "student/detail";
	}
	
	@RequestMapping("/student/delete")
	public String delete(HttpServletRequest request) {
		
		String num = request.getParameter("num");
		StudentDTO stdto = new StudentDTO();
		
		stdto.setNum(Integer.parseInt(num));
		
		studentService.delete(stdto);

		return "redirect:/student/list";
	}
	
	@RequestMapping(value = "/student/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request) {
		StudentDTO stdto = new StudentDTO();
		stdto.setNum(Integer.parseInt(request.getParameter("num")));

		stdto = studentService.getDetail(stdto);
		request.setAttribute("dto", stdto);
		return "student/update";
	}
	@RequestMapping(value = "/student/update", method = RequestMethod.POST)
	public String update2(HttpServletRequest request) {
		StudentDTO stdto = new StudentDTO();
		stdto.setCity(request.getParameter("city"));
		stdto.setGion(Double.parseDouble(request.getParameter("gion")));
		stdto.setStatus(request.getParameter("Status"));
		stdto.setHuminity(Integer.parseInt(request.getParameter("huminity")));
											
		studentService.update(stdto);
		
		return "redirect:/student/list";
	}
	
}
