package com.query.query.dtoresposta;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ProfessorDtoResposta extends PessoaDtoResposta implements Serializable{
	
	private static final long serialVersionUID = -3128532195664377050L;
	private Integer idProfessor;
	private String titulacao;

}
