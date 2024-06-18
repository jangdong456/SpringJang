package com.jang.app.weather;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {
	private WeatherDAO w;

	public WeatherService() {
		w = new WeatherDAO();
	}

	public List<WeatherDTO> getWeathers() {
		List<WeatherDTO> lAr = null;
		try {
			lAr = w.getWeathers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lAr;
	}

	public WeatherDTO getDetail(WeatherDTO weatherDTO) {
		try {
			weatherDTO = w.getDetail(weatherDTO);
		} catch (Exception e) {
			e.printStackTrace();
			weatherDTO = null;
		}
		return weatherDTO;

	}

	public WeatherDTO add(WeatherDTO dto) {
		try {
			dto = w.add(dto);
		} catch (Exception e) {
			e.printStackTrace();
			dto = null;
		}
		return dto;
	}

	public List<WeatherDTO> delete(WeatherDTO weatherDTO) {
		List<WeatherDTO> ar = null;
		try {
			w.delete(weatherDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}

	public void update(WeatherDTO weatherDTO) {
		// 좀전까지 list로 인해 null값이 존재하게 됨
		try { // 만든 데이터 받아와서 return함
			w.update(weatherDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
