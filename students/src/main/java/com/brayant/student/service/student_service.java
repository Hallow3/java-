package com.brayant.student.service;

import java.util.List;

import com.brayant.student.entity.student;


public interface student_service{
	List<student> getAllStudents();
	
	student addStudent(student s);
	
	void deleteStudent(Long id);
	
	student getbyid(Long id);
	
	student editStudent(student s);
	
	Long getByTId(Long id);
}
