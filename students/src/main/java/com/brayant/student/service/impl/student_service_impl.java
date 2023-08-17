package com.brayant.student.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brayant.student.entity.student;
import com.brayant.student.repository.student_repository;
import com.brayant.student.service.student_service;

@Service
public class student_service_impl implements student_service{
	
	private student_repository studentRepository;
	
	public student_service_impl(student_repository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<student> getAllStudents() {
		return studentRepository.findAll();
	}


	@Override
	public student addStudent(student s) {
		return studentRepository.save(s);
	}


	@Override
	public student getbyid(Long id) {
		return studentRepository.findById(id).get();
	}


	@Override
	public student editStudent(student s) {
		return studentRepository.save(s);
	}


	@Override
	public void deleteStudent(Long id) {
	    studentRepository.deleteById(id);
	}


	@Override
	public Long getByTId(Long id) {
		return studentRepository.findByTeacherId(id);
	}

}
