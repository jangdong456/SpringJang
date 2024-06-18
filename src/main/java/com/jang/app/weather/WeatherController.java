package com.jang.app.weather;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WeatherController {
	@Autowired
	WeatherService weatherService;

	@RequestMapping("weather/list")
	public String getList(HttpServletRequest request) {
		request.getParameter("");
		System.out.println("list 가져오기");
		weatherService.getlist(); // ??
		return "weather/list";
	}

	@RequestMapping("weather/detail")
	public String getDetail() {
		System.out.println("detail입니다");
		System.out.println("--");
		return "weather/detail";
	}
	
	 // 2개이상 이면 무조건 속성명 써야한다.
	// method 기본은 get이다.
	@RequestMapping(value = "weather/add", method=RequestMethod.GET)
	public void add() {
		
	}
	
	@RequestMapping(value = "weather/add", method=RequestMethod.POST)
	public void add2() {
		
	}
}
