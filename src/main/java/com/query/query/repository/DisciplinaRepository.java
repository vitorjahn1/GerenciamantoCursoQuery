package com.query.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.query.query.model.Disciplina;



public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

	
	Disciplina findByIdDisciplina(Integer idDisciplina);
}
