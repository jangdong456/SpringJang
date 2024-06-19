package com.jang.app.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class StudentDAO {
	
	
	public List<StudentDTO> getList()throws Exception {
//		File file = new File("C:\\study\\weather.txt");
		File file = new File("C:\\Users\\l\\OneDrive\\바탕 화면\\weather.txt");
			
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
	
	public void add(StudentDTO studentDTO) throws Exception {
		System.out.println("add ========== ");

//		File file = new File("C:\\study\\weather.txt");
		File file = new File("C:\\Users\\l\\OneDrive\\바탕 화면\\weather.txt");
		StringBuffer sb = new StringBuffer();
		FileWriter fw = new FileWriter(file,true);
		
		List<StudentDTO> ar = this.getList();
		
		sb.append(ar.size()+1);
		sb.append("-");
		sb.append(studentDTO.getCity());
		sb.append("-");
		sb.append(studentDTO.getGion());
		sb.append("-");
		sb.append(studentDTO.getStatus());
		sb.append("-");
		sb.append(studentDTO.getHuminity());
		
		fw.write(sb.toString()+ "\r\n");
		fw.flush();
		fw.close();
	}
	
	public StudentDTO getDetail(StudentDTO studentDTO) throws Exception {
		System.out.println("디테일 임돠");
		List<StudentDTO> ar = this.getList();
		
		StudentDTO result = null;
		
		for(StudentDTO s : ar) {
			if(s.getNum() == studentDTO.getNum()) {
				result = s;
				break;
			}
		}
		return result;
	}
	
	public void delete(StudentDTO studentDTO) throws Exception {
		System.out.println("delete");
//		File file = new File("C:\\study\\weather.txt");
		File file = new File("C:\\Users\\l\\OneDrive\\바탕 화면\\weather.txt");
		
		List<StudentDTO> ar = this.getList();

		for(StudentDTO s : ar) {
			if(s.getNum() == studentDTO.getNum()) {
				ar.remove(s);
				break;
			}
		}
		
		FileWriter fw = new FileWriter(file, false);
		StringBuffer sb = new StringBuffer();
		for(StudentDTO s: ar) {
			sb.append(s.getNum());
			sb.append("-");
			sb.append(s.getCity());
			sb.append("-");
			sb.append(s.getGion());
			sb.append("-");
			sb.append(s.getStatus());
			sb.append("-");
			sb.append(s.getHuminity());
			sb.append("\r\n");
		}
		
		fw.write(sb.toString() + "\r\n");
		fw.flush();
		fw.close();
	}
	
	public void update(StudentDTO studentDTO)throws Exception {
		List<StudentDTO> ar = this.getList();
		for (int i = 0; i < ar.size(); i++) {
			if (ar.get(i).getNum() == studentDTO.getNum()) {
				ar.set(i, studentDTO);
			}
		}
		
//		File file = new File("C:\\study\\weather.txt");
		File file = new File("C:\\Users\\l\\OneDrive\\바탕 화면\\weather.txt");
		FileWriter fw = new FileWriter(file, false);
		StringBuffer sb = new StringBuffer();

		for (StudentDTO dto : ar) {
			sb.append(dto.getNum());
			sb.append("-");
			sb.append(dto.getCity());
			sb.append("-");
			sb.append(dto.getGion());
			sb.append("-");
			sb.append(dto.getStatus());
			sb.append("-");
			sb.append(dto.getHuminity());
			sb.append("\r\n");
		}
		
		fw.write(sb.toString() + "\r\n");
		fw.flush();
		fw.close();
	}
}
