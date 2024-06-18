package com.jang.app.weather;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeatherController {
	WeatherService weatherService;

	@RequestMapping("weather/list")
	public String getList(HttpServletRequest request) {
		System.out.println("list 가져오기");
		weatherService.getlist(); // ??
		return "weather/list";
	}

	@RequestMapping("weather/detail")
	public String getDetail() {
		System.out.println("detail입니다");
		return "weather/detail";
	}
}
