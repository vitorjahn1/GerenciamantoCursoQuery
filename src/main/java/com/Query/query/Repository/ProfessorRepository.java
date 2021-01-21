package com.Query.query.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Query.query.Model.Professor;



public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

	Professor getOne(Integer id);


}
