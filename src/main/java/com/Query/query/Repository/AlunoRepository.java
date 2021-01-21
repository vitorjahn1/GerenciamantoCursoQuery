package com.Query.query.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Query.query.Model.Aluno;





public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	
	Aluno findByMatricula(Integer matricula);
	
}
