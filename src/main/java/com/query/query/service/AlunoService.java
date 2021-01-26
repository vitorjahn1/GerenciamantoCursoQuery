package com.query.query.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.query.query.dto.AlunoDto;
import com.query.query.exception.AlunoException;
import com.query.query.model.Aluno;
import com.query.query.repository.AlunoRepository;

import lombok.AllArgsConstructor;
@Service
@Transactional
@AllArgsConstructor
public class AlunoService {

	
	private final AlunoRepository alunoRepository;

	public AlunoDto retornaAluno(Integer matricula) {

		Aluno alunoRetorno = alunoRepository.findByMatricula(matricula);
		if(alunoRetorno==null) {
			
		throw new AlunoException("Aluno não encontrado");
			
		}
		
		AlunoDto alunoDto = criarAlunoDto(alunoRetorno);
		return alunoDto;
	}

	public List<AlunoDto> retornaAlunos() {
		
		List<Aluno> alunos = alunoRepository.findAll();
		List<AlunoDto> alunosDtos = new ArrayList<AlunoDto>();
		for(Aluno aluno : alunos) {
			
			alunosDtos.add(criarAlunoDto(aluno));
		}
		
		return alunosDtos;
	}
	
	public AlunoDto criarAlunoDto(Aluno alunoModel) {
		
		AlunoDto alunoDto = new AlunoDto();
		
		if(alunoModel!= null) {
			
			alunoDto.setCpf(alunoModel.getCpf());
			alunoDto.setEmail(alunoModel.getEmail());
			alunoDto.setFormaIngresso(alunoModel.getFormaIngresso());
			alunoDto.setNome(alunoModel.getNome());
			alunoDto.setTurma(alunoModel.getTurma());
		}
		
		return alunoDto;
		
	} 

}
