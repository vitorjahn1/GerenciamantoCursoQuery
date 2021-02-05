package com.query.query.dtoresposta;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;
@Data
public class DisciplinaDtoResposta implements Serializable{

	private static final long serialVersionUID = -186012090209992292L;
	private Integer idDisciplina;
	private String descricao;
	private String cargaHoraria;
	private String sigla;
	private Set<ProfessorDtoResposta> professores;
}
