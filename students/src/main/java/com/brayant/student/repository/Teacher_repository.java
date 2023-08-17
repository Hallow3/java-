package com.brayant.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brayant.student.entity.Teacher;

@Repository
public interface Teacher_repository extends JpaRepository<Teacher, Long>{

}
