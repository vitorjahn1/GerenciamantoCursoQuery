package com.projetogerenciamentocurso.gerenciamentocurso.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class ProfessorDto extends PessoaDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer idProfessor;
	
	private String titulacao;
	
}
