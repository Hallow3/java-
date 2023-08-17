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

import com.brayant.student.entity.Teacher;
import com.brayant.student.repository.Teacher_repository;
import com.brayant.student.service.Teacher_service;

@RestController
@CrossOrigin(origins = "*")
public class Teacher_controller {

	private Teacher_service teacher_service;
	private Teacher_repository teacher_repository;
	
	public Teacher_controller(Teacher_service teacher_service, Teacher_repository teacher_repository) {
		super();
		this.teacher_service = teacher_service;
		this.teacher_repository = teacher_repository;
	}

	@GetMapping("/Teachers")
	public List<Map<String, String>> getAllTeachers() {
		List<Map<String, String>> teachers = new ArrayList<>();
		List<Teacher> t = teacher_repository.findAll();
		for(Teacher teacher: t) {
			Map<String, String> tableau = new HashMap<>();
			tableau.put("identifaint", teacher.getId_teacher().toString());
			tableau.put("nom", teacher.getNameTeacher());
			tableau.put("experience", teacher.getExperience());
			System.out.println(teacher.getNameTeacher());
			teachers.add(tableau);
		}
		return teachers;
	}
	
	/*
	 * @GetMapping("/Teachers/new") public String formaddTeacher(Model model) {
	 * Teacher teacher = new Teacher(); model.addAttribute("teacher",teacher);
	 * return "formulaire_teachers"; }
	 */
	
	@PostMapping("/Teachers")
	public String addTeacher(@RequestBody Teacher teacher) {
		teacher_service.addTeacher(teacher);
		return "prof ajouter !";
	}
	
	/*
	 * @GetMapping("/Teacher/edit/{id}") public String formEditTeacher(@PathVariable
	 * Long id, Model model) {
	 * model.addAttribute("teacher",teacher_service.getById(id)); return
	 * "formulaireEdit_teacher.html"; }
	 */
	
	@PostMapping("/Teacher/{id}")
	public boolean EditTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
		Teacher teacherToUpdate = new Teacher();
	    teacherToUpdate = teacher_service.getById(id);
		teacherToUpdate.setNameTeacher(teacher.getNameTeacher());
		teacherToUpdate.setExperience(teacher.getExperience());
		
		teacher_service.editTeacher(teacherToUpdate);
		
		return true;
	}
	
	@GetMapping("/Teacher/delete/{id}")
	public String deleteTeacher(@PathVariable Long id) {
		teacher_service.deleteTeacher(id);
		return "prof supprimer !";
	}
	
	@GetMapping("/Teacher/{id}")
	public Map<String, String> getTeacherById(@PathVariable Long id) {
		Teacher teacher = teacher_service.getById(id);
		Map<String, String> tableau = new HashMap<>();
		tableau.put("identifiant", teacher.getId_teacher().toString());
		tableau.put("nom", teacher.getNameTeacher());
		tableau.put("experience", teacher.getExperience());
		System.out.println(teacher.getNameTeacher());
		return (tableau != null ? tableau: null);
	}
	
}
