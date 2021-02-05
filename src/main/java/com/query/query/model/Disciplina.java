package com.query.query.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor
public class Disciplina implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private Integer idDisciplina;
	private String descricao;
	private String cargaHoraria;
	private String sigla;
	@OneToMany
	private Set<Professor> professores;
}
