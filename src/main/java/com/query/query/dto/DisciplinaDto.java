package com.query.query.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DisciplinaDto implements Serializable{

	private static final long serialVersionUID = -3984794552136348183L;

	private Integer idDisciplina;
	
	private String descricao;
	
	private String cargaHoraria;
	
	private String sigla;
	
	private ProfessorDto professor;

}
