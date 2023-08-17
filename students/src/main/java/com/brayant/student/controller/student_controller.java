package com.brayant.student.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brayant.student.entity.student;
import com.brayant.student.service.student_service;

@RestController
@CrossOrigin(origins = "*")
public class student_controller {
	private student_service studentService;
	//private Teacher_service teacherService;

	public student_controller(student_service studentService) {
		super();
		this.studentService = studentService;
		//this.teacherService = teacherService;
	}
	
	@GetMapping("/students")
	public List<Map<String, String>> getAllstudents() {
		List<Map<String, String>> students = new ArrayList<>();
		List<student> t = studentService.getAllStudents();
		for(student student: t) {
			Map<String, String> tableau = new HashMap<>();
			tableau.put("identifaint", student.getId().toString());
			tableau.put("prenom", student.getFirstName());
			tableau.put("nom", student.getLastName());
			tableau.put("e-mail", student.getEmail());
			tableau.put("enseignant", student.getTeacher().getNameTeacher());
			System.out.println(student.getFirstName());
			students.add(tableau != null? tableau : null);
		}
		return students;
	}
	
	/*
	 * @GetMapping("/students/new") public String formaddStudent(Model model) {
	 * student student = new student(); List<Teacher> listTeachers =
	 * teacherService.getAllTeacher(); model.addAttribute("student", student);
	 * model.addAttribute("listTeachers", listTeachers); return "formulaire";
	 *}
	 */
	
	@PostMapping("/students")
	public boolean addStudent(@RequestBody student student) {
		studentService.addStudent(student);
		return true;
	}
	
	/*
	 * @GetMapping("/student/edit/{id}") public String editSutdent(@PathVariable
	 * Long id, Model model) { List<Teacher> listTeachers =
	 * teacherService.getAllTeacher(); model.addAttribute("listTeachers",
	 * listTeachers); model.addAttribute("student", studentService.getbyid(id));
	 * return "formulaireEdit"; }
	 */
	
	@PostMapping("/students/{id}")
	public boolean update(@PathVariable Long id, @RequestBody student student) {
		student newstudent = new student();
		newstudent = studentService.getbyid(id);
		newstudent.setFirstName(student.getFirstName());
		newstudent.setLastName(student.getLastName());
		newstudent.setEmail(student.getEmail());
		newstudent.setTeacher(student.getTeacher());
		
		studentService.editStudent(newstudent);
		
		return true;
		
	}
	
	@GetMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "etudiant supprimer avec succes";
	}
	
	@GetMapping("/student/{id}")
	public Map<String, String> getStudentById(@PathVariable Long id) {
		student student = studentService.getbyid(id);
		Map<String, String> tableau = new HashMap<>();
		tableau.put("identifaint", student.getId().toString());
		tableau.put("prenom", student.getFirstName());
		tableau.put("nom", student.getLastName());
		tableau.put("e-mail", student.getEmail());
		tableau.put("enseignant", student.getTeacher().getNameTeacher());
		System.out.println(student.getFirstName());
		return (tableau);
	}

}
