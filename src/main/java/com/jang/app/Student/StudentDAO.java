package com.jang.app.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {
	
	
	public List<StudentDTO> getList()throws Exception {
		System.out.println("Student DAO 입니다.");
		
		File file = new File("C:\\study\\weather.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		
		boolean flag = true;
		
		while(flag) {
			String st = br.readLine();
			if(st == null) {
				break;
			}
			
			String[] ar = st.split("-");
			StudentDTO stdo = new StudentDTO();
			stdo.setNum(Integer.parseInt(ar[0].trim()));
			stdo.setCity(ar[1].trim());
			stdo.setGion(Double.parseDouble(ar[2].trim()));
			stdo.setStatus((ar[3].trim()));
			stdo.setHuminity(Integer.parseInt(ar[4].trim()));
		
			list.add(stdo);
		}
		return list;
	}
	
}
