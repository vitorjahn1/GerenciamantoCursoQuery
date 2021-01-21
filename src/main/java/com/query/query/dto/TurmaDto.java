package com.query.query.dto;

import java.util.HashSet;
import java.util.Set;

import com.query.query.model.Aluno;
import com.query.query.model.Disciplina;

import lombok.Data;

@Data
public class TurmaDto {
	
	private Integer idTurma;
	
	private String anoLetivo;
	
	private String descricao;
	
	private Integer numeroVagas;
	
	private Integer periodoLetivo;

	private Set<Disciplina> disciplinas = new HashSet<>();
	
	private Set<Aluno> alunos = new HashSet<>();
}

