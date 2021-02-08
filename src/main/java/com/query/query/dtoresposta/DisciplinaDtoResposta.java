package com.query.query.dtoresposta;

import java.io.Serializable;

import lombok.Data;
@Data
public class DisciplinaDtoResposta implements Serializable{

	private static final long serialVersionUID = -186012090209992292L;
	private Integer idDisciplina;
	private String descricao;
	private String cargaHoraria;
	private String sigla;
	private ProfessorDtoResposta professor;
}
