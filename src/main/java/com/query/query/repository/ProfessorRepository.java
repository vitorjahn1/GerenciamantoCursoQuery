package com.query.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.query.query.model.Professor;



public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

	Professor findByIdProfessor(Integer id);


}
