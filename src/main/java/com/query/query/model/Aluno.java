package com.query.query.model;

import java.io.Serializable;

import javax.persistence.Entity;

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
	public Aluno(Integer idPessoa, String nome, String cpf, String email, String formaIngresso
			) {
		super(idPessoa, nome, cpf, email);
		this.formaIngresso = formaIngresso;
		this.matricula = idPessoa;
	}

}
