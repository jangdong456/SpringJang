package com.jang.app.Student;

import java.util.List;

import org.springframework.stereotype.Service;

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
	
}
