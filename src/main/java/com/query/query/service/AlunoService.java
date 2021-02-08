package com.query.query.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.query.query.dto.AlunoDto;
import com.query.query.dtoresposta.AlunoDtoResposta;
import com.query.query.exception.AlunoException;
import com.query.query.model.Aluno;
import com.query.query.repository.AlunoRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AlunoService {

	private final AlunoRepository alunoRepository;

	public AlunoDtoResposta retornaAluno(Integer matricula) {

		Aluno alunoRetorno = alunoRepository.findByMatricula(matricula);

		if (alunoRetorno == null)
			throw new AlunoException("Aluno não encontrado");

		
		return criarAlunoDtoResposta(alunoRetorno);
	}

	public List<AlunoDtoResposta> retornaAlunos() {

		List<AlunoDtoResposta> alunosDtoResposta = new ArrayList<>();
		for (Aluno aluno :  alunoRepository.findAll()) {

			alunosDtoResposta.add(criarAlunoDtoResposta(aluno));
		}

		return alunosDtoResposta;
	}

	public AlunoDto criarAlunoDto(Aluno alunoModel) {

		AlunoDto alunoDto = new AlunoDto();

		if (alunoModel != null) {

			alunoDto.setCpf(alunoModel.getCpf());
			alunoDto.setEmail(alunoModel.getEmail());
			alunoDto.setFormaIngresso(alunoModel.getFormaIngresso());
			alunoDto.setNome(alunoModel.getNome());
			alunoDto.setIdPessoa(alunoModel.getIdPessoa());
			alunoDto.setMatricula(alunoModel.getMatricula());
		}

		return alunoDto;

	}

	public AlunoDtoResposta criarAlunoDtoResposta(Aluno alunoModel) {

		AlunoDtoResposta alunoDtoResposta = new AlunoDtoResposta();

		if (alunoModel != null) {

			alunoDtoResposta.setCpf(alunoModel.getCpf());
			alunoDtoResposta.setEmail(alunoModel.getEmail());
			alunoDtoResposta.setFormaIngresso(alunoModel.getFormaIngresso());
			alunoDtoResposta.setNome(alunoModel.getNome());
			alunoDtoResposta.setIdPessoa(alunoModel.getIdPessoa());
			alunoDtoResposta.setMatricula(alunoModel.getMatricula());
		}

		return alunoDtoResposta;

	}
}
