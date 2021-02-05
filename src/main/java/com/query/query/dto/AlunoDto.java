package com.query.query.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper=false)
@Data
public class AlunoDto extends PessoaDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer matricula;

	private String formaIngresso;

}
