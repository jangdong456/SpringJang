package com.jang.app.Student;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jang.app.weather.WeatherDTO;

@Service
public class StudentService {
	
	private StudentDAO studentDAO;
	
	public StudentService() {
		studentDAO = new StudentDAO();
	}
	
	public List<StudentDTO> getList() {
		List<StudentDTO> ar = null; 
		try {
			ar = studentDAO.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}
	
	public void add(StudentDTO studentDTO) {
		try {
			studentDAO.add(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public StudentDTO getDetail(StudentDTO studentDTO) {
		try {
			studentDTO = studentDAO.getDetail(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			studentDTO = null;
			
		} return studentDTO;
	}
	
	public void delete(StudentDTO studentDTO) {
		try {
			studentDAO.delete(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void update(StudentDTO studentDTO) {
		// 좀전까지 list로 인해 null값이 존재하게 됨
		try { // 만든 데이터 받아와서 return함
			studentDAO.update(studentDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
