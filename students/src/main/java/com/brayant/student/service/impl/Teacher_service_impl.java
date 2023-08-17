package com.brayant.student.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brayant.student.entity.Teacher;
import com.brayant.student.entity.student;
import com.brayant.student.exception.NoPermissionException;
import com.brayant.student.repository.Teacher_repository;
import com.brayant.student.service.Teacher_service;
import com.brayant.student.service.student_service;

@Service
public class Teacher_service_impl implements Teacher_service{

	private Teacher_repository teacherRepository;
	private student_service studentService;
	
	
	public Teacher_service_impl(Teacher_repository teacherRepository, student_service studentService) {
		super();
		this.teacherRepository = teacherRepository;
		this.studentService = studentService;
	}

	@Override
	public List<Teacher> getAllTeacher() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher addTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public Teacher getById(Long id) {
		return teacherRepository.findById(id).get();
	}

	@Override
	public Teacher editTeacher(Teacher teacherToUpdate) {
		return teacherRepository.save(teacherToUpdate);
	}

	@Override
	public void deleteTeacher(Long id) {
		Long s = studentService.getByTId(id);
		if(s==null) {
			teacherRepository.deleteById(id);	
		}else {
			throw new NoPermissionException("l'enseignant ne peut pas etre supprimer tant qu'il administre des élèves veillez modifier dans la liste des élèves");
		}
		
	}

	@Override
	public Teacher addStudentToTeacher(Long id_teacher, Long id) {
		Teacher teacher = teacherRepository.findById(id_teacher).get();
		student student = studentService.getbyid(id);
		teacher.addStudent(student);
		
		return teacher;
	}

	@Override
	public Teacher removeStudentToTeacher(Long id_teacher, Long id) {
		Teacher teacher = teacherRepository.findById(id_teacher).get();
		student student = studentService.getbyid(id);
		teacher.removeStudent(student);
		
		return teacher;
	}

}
