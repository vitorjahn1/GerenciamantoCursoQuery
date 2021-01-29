package com.query.query.dto;

import java.util.HashSet;
import java.util.Set;

import com.query.query.model.Pessoa;
import com.query.query.model.Turma;

import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper=false)
@Data
public class AlunoDto extends Pessoa{

	private static final long serialVersionUID = 1L;

	private Integer matricula;

	private String formaIngresso;

	private Set<Turma> turma = new HashSet<>();

}
