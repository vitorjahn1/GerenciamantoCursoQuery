package com.Query.query.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Aluno extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer matricula;
	@NotNull
	private String formaIngresso;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Turma> turma = new HashSet<Turma>();

	public Aluno(Integer idPessoa, String nome, String cpf, String email, Integer matricula, String formaIngresso,
			Set<Turma> turma) {
		super(idPessoa, nome, cpf, email);
		this.matricula = super.getIdPessoa();
		this.formaIngresso = formaIngresso;
		this.turma = turma;
	}

}
