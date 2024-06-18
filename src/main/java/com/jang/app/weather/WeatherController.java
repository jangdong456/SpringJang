package com.jang.app.weather;

import java.util.List;

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
		List<WeatherDTO> list = weatherService.getWeathers();
		request.setAttribute("list", list);
		System.out.println("list 가져오기");
		weatherService.getWeathers();
		return "weather/list";
	}

	@RequestMapping("weather/detail")
	public String getDetail(HttpServletRequest request) {
		String num = request.getParameter("num");
		WeatherDTO weatherDTO = new WeatherDTO();
		weatherDTO.setNum(Long.parseLong(num));
		weatherDTO = weatherService.getDetail(weatherDTO);
		if (weatherDTO != null) {
			request.setAttribute("dto", weatherDTO);
		}
//		} else {
//			request.setAttribute("message", "정보가 없습니다.");
//			action.setPath("/WEB-INF/views/commons/message.jsp");
//		}
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

	@RequestMapping(value = "/weather/add", method = RequestMethod.GET)
	public String add() { // 안쓰면 기본이 get --> 속성으로 드갈 때 속성명
		return "weather/add";
	}

	@RequestMapping(value = "/weather/add", method = RequestMethod.POST)
	public String add2(HttpServletRequest request) {
		String city = request.getParameter("city");
		double gion = Double.parseDouble(request.getParameter("gion"));
		int huminity = Integer.parseInt(request.getParameter("huminity"));
		String status = request.getParameter("status");

		WeatherDTO w = new WeatherDTO();
		w.setCity(city);
		w.setGion(gion);
		w.setHuminity(huminity);
		w.setStatus(status);
		weatherService.add(w);
		return "redirect:/weather/list";
	}

	@RequestMapping(value = "/weather/delete", method = RequestMethod.POST)
	public String remove(HttpServletRequest request) {
		WeatherDTO weatherDTO = new WeatherDTO();
		String num = request.getParameter("num");
		weatherDTO.setNum(Integer.parseInt(num));
		List<WeatherDTO> list = weatherService.delete(weatherDTO);
		return "redirect:/weather/list";
	}

	@RequestMapping(value = "/weather/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		WeatherDTO weatherDTO = new WeatherDTO();
		String num = request.getParameter("num");
		String city = request.getParameter("city");
		String gion = request.getParameter("gion");
		String status = request.getParameter("status");
		String huminity = request.getParameter("huminity");
		weatherDTO.setNum(Long.parseLong(num));
		weatherDTO.setCity(city);
		weatherDTO.setGion(Double.parseDouble(gion));
		weatherDTO.setStatus(status);
		weatherDTO.setHuminity(Integer.parseInt(huminity));
		weatherService.update(weatherDTO);
		return "redirect:/weather/list";
	}

	@RequestMapping(value = "/weather/update", method = RequestMethod.GET)
	public String update2(HttpServletRequest request) {
		WeatherDTO weatherDTO = new WeatherDTO();
		weatherDTO.setNum(Long.parseLong(request.getParameter("num")));

		weatherDTO = weatherService.getDetail(weatherDTO);
		request.setAttribute("dto", weatherDTO);
		return "weather/update";
	}

}
