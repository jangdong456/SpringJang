package com.jang.app.weather;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
