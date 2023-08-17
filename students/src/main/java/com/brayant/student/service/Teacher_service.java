package com.brayant.student.service;

import java.util.List;

import com.brayant.student.entity.Teacher;

public interface Teacher_service {
	
	List<Teacher> getAllTeacher();

	Teacher addTeacher(Teacher teacher);

	Teacher getById(Long id);

	Teacher editTeacher(Teacher teacherToUpdate);
	
	void deleteTeacher(Long id);
	
	Teacher addStudentToTeacher(Long id_teacher, Long id);
	
	Teacher removeStudentToTeacher(Long id_teacher, Long id);

}
