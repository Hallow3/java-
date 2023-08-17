package com.brayant.student.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id_teacher;
	
	@Column(name = "name_teacher")
	public String nameTeacher;
	
	@Column(name = "experience")
	public String experience;
	
	@OneToMany(mappedBy = "teacher")
	public List<student> students;
	
	public List<student> getStudents() {
		return students;
	}
	public void setStudents(List<student> students) {
		this.students = students;
	}
	
    public Teacher() {
		
	}
	public Teacher(Long id_teacher, String name_teacher, String experience) {
		super();
		this.id_teacher = id_teacher;
		this.nameTeacher = name_teacher;
		this.experience = experience;
	}
	public Long getId_teacher() {
		return id_teacher;
	}
	public void setId_teacher(Long id_teacher) {
		this.id_teacher = id_teacher;
	}
	public String getNameTeacher() {
		return nameTeacher;
	}
	public void setNameTeacher(String nameTeacher) {
		this.nameTeacher = nameTeacher;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	public void addStudent(student student) {
		students.add(student);
	}
	
	public void removeStudent(student student) {
		students.remove(student);
	}
	@Override
	public String toString() {
		return "Teacher [id_teacher=" + id_teacher + ", nameTeacher=" + nameTeacher + ", experience=" + experience
				+ ", students=" + students + "]";
	}
	
	
}
