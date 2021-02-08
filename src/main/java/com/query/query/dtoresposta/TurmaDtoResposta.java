package com.query.query.dtoresposta;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
@Data
public class TurmaDtoResposta implements Serializable{
	
	private static final long serialVersionUID = -7939140333465114129L;
	private Integer idTurma;
	private String anoLetivo;
	private String descricao;
	private Integer numeroVagas;
	private Integer periodoLetivo;
	private Set<DisciplinaDtoResposta> disciplinas = new HashSet<>();
	private Set<AlunoDtoResposta> alunos = new HashSet<>();

}
