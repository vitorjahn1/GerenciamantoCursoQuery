package com.query.query.dto;



import java.io.Serializable;

import javax.persistence.Id;

import lombok.Data;
@Data
public class PessoaDto  implements Serializable{
	
	private static final long serialVersionUID = -4599548274533012052L;
	@Id 
	private Integer idPessoa;
	private String nome;
	private String cpf;
	private String email;
}
