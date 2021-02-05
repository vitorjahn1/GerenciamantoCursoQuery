package com.query.query.dtoresposta;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AlunoDtoResposta extends PessoaDtoResposta implements Serializable{

	private static final long serialVersionUID = -3401741072663817863L;
	private Integer matricula;
	private String formaIngresso;

}
