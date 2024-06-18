package com.jang.app.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Repository;

@Repository
public class WeatherDAO {

	public List<WeatherDTO> getWeathers() throws Exception {
		File file = new File("C:\\study", "weather.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		List<WeatherDTO> lAr = new ArrayList();
		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;
			}
			s = s.replace(",", "-");
			StringTokenizer st = new StringTokenizer(s, "-");
			while (st.hasMoreTokens()) {
				WeatherDTO w = new WeatherDTO();
				w.setNum(Long.parseLong(st.nextToken().trim()));
				w.setCity(st.nextToken().trim());
				w.setGion(Double.parseDouble(st.nextToken().trim()));
				w.setStatus(st.nextToken().trim());
				w.setHuminity(Integer.parseInt(st.nextToken().trim()));
				lAr.add(w);
			}
		}
		br.close();
		fr.close();
		return lAr;
	}

	public WeatherDTO getDetail(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getWeathers();
		WeatherDTO result = null;

		for (int i = 0; i < ar.size(); i++) {
			if (ar.get(i).getNum() == weatherDTO.getNum()) {
				result = ar.get(i);
				break;
			}
		}
		return result;
	}

	public WeatherDTO add(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getWeathers();
		StringBuffer stringBuffer = new StringBuffer();
		Calendar ca = Calendar.getInstance();
		stringBuffer.append(ca.getTimeInMillis());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getCity());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getGion());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getStatus());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getHuminity());
		System.out.println(stringBuffer);

		File file = new File("C:\\study", "weather.txt");
		FileWriter fw = new FileWriter(file, true);
		fw.write(stringBuffer.toString() + "\r\n");

		fw.flush();
		fw.close();
		return weatherDTO;
	}

	public void delete(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> list = this.getWeathers();
		for (WeatherDTO dto : list) {
			if (dto.getNum() == weatherDTO.getNum()) {
				list.remove(dto);
				break;
			}

		}
		File file = new File("C:\\study", "weather.txt");
		FileWriter fw = new FileWriter(file, false);
		for (WeatherDTO dto : list) {
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(dto.getNum());
			stringBuffer.append("-");
			stringBuffer.append(dto.getCity());
			stringBuffer.append("-");
			stringBuffer.append(dto.getGion());
			stringBuffer.append("-");
			stringBuffer.append(dto.getStatus());
			stringBuffer.append("-");
			stringBuffer.append(dto.getHuminity());
			fw.write(stringBuffer.toString() + "\r\n");
			fw.flush();
		}
	}

	public void update(WeatherDTO weatherDTO) throws Exception { // 받아왔음
		List<WeatherDTO> list = this.getWeathers();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNum() == weatherDTO.getNum()) {
				list.set(i, weatherDTO);
			}
		}

		File file = new File("C:\\study", "weather.txt");
		FileWriter fw = new FileWriter(file, false);
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).getNum()).append("-");
			sb.append(list.get(i).getCity()).append("-");
			sb.append(list.get(i).getGion()).append("-");
			sb.append(list.get(i).getStatus()).append("-");
			sb.append(list.get(i).getHuminity()).append("-\n");
		}
		fw.write(sb.toString() + "\r\n");
		fw.flush();
		fw.close();
	}

}
