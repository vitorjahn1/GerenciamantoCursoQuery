package com.Query.query.Dto;


import java.util.HashSet;
import java.util.Set;

import com.Query.query.Model.Pessoa;
import com.Query.query.Model.Turma;

import lombok.Data;

@Data
public class AlunoDto extends Pessoa{

	private static final long serialVersionUID = 1L;

	private Integer matricula;

	private String formaIngresso;

	private Set<Turma> turma = new HashSet<>();

}
