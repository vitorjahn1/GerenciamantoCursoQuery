package com.Query.query.Dto;



import com.Query.query.Model.Disciplina;
import com.Query.query.Model.Pessoa;

import lombok.Data;

@Data
public class ProfessorDto extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private Integer idProfessor;
	
	private String titulacao;
	
	private Disciplina disciplina;
}
