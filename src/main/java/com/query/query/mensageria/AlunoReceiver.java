package com.query.query.mensageria;

import javax.persistence.EntityNotFoundException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.query.query.dto.AlunoDto;
import com.query.query.exception.AlunoException;
import com.query.query.model.Aluno;
import com.query.query.repository.AlunoRepository;

@Component
public class AlunoReceiver {

	@Autowired
	AlunoRepository alunoRepository;

	@RabbitListener(queues = { "alunoCriar" })
	public void criarAluno(AlunoDto alunoDto) {

		alunoRepository.save(criarAlunoModel(alunoDto));

	}

	@RabbitListener(queues = { "alunoAtualizar" })
	public void atualizarAluno(AlunoDto alunoDto) {
		try {
			Aluno aluno = alunoRepository.getOne(alunoDto.getIdPessoa());

			aluno.setCpf(alunoDto.getCpf());
			aluno.setEmail(alunoDto.getEmail());
			aluno.setFormaIngresso(alunoDto.getFormaIngresso());
			aluno.setNome(alunoDto.getNome());
			aluno.setTurma(alunoDto.getTurma());

			alunoRepository.save(aluno);
		} catch (EntityNotFoundException  e) {
			throw new AlunoException("Aluno não encontrado");
		}
	}

	@RabbitListener(queues = { "alunoDeletar" })
	public void deletarAluno(AlunoDto alunoDto) {
		
		try {
			Aluno alunoAchado = alunoRepository.getOne(alunoDto.getIdPessoa());
			
			alunoRepository.delete(alunoAchado);
		}catch (EntityNotFoundException  e) {
			throw new AlunoException("Aluno não encontrado");
		}
	}

	public Aluno criarAlunoModel(AlunoDto alunoDto) {

		Aluno alunoModel = new Aluno();

		alunoModel.setCpf(alunoDto.getCpf());
		alunoModel.setEmail(alunoDto.getEmail());
		alunoModel.setFormaIngresso(alunoDto.getFormaIngresso());
		alunoModel.setNome(alunoDto.getNome());
		alunoModel.setTurma(alunoDto.getTurma());

		return alunoModel;
	}
}
