package com.query.query.model;

import java.io.Serializable;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
public class Professor extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idProfessor;
	private String titulacao;
	
	public Professor(Integer idPessoa, String nome, String cpf, String email,String titulacao) {
		super(idPessoa, nome, cpf, email);
		this.idProfessor = idPessoa;
		this.titulacao = titulacao;
	}
	
	
}
