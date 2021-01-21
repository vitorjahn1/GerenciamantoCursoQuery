package com.query.query.dto;





import com.query.query.model.Disciplina;
import com.query.query.model.Pessoa;

import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper=false)
@Data
public class ProfessorDto extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private Integer idProfessor;
	
	private String titulacao;
	
	private Disciplina disciplina;
}
