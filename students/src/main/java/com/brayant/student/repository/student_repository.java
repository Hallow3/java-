package com.brayant.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brayant.student.entity.student;

@Repository
public interface student_repository extends JpaRepository<student, Long>{

	@Query("select id from students where id_teacher = :x")
	Long findByTeacherId(@Param("x") Long id);

}
