package com.query.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.query.query.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	
	Aluno findByMatricula(Integer matricula);
	
}
