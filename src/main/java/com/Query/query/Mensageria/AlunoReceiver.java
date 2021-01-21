package com.Query.query.Mensageria;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Query.query.Model.Aluno;
import com.Query.query.Repository.AlunoRepository;

@Component
public class AlunoReceiver {

	@Autowired
	AlunoRepository alunoRepository;

	@RabbitListener(queues = { "alunoCriar" })
	public void criarAluno(Aluno aluno) {

		alunoRepository.save(aluno);

	}

	@RabbitListener(queues = { "alunoAtualizar" })
	public void atualizarAluno(Aluno atualizaAluno) {

		Aluno aluno = alunoRepository.getOne(atualizaAluno.getIdPessoa());

		if (aluno != null) {

			aluno.setCpf(atualizaAluno.getCpf());
			aluno.setEmail(atualizaAluno.getEmail());
			aluno.setFormaIngresso(atualizaAluno.getFormaIngresso());
			aluno.setNome(atualizaAluno.getNome());
			aluno.setTurma(atualizaAluno.getTurma());

		} else {

		}

		alunoRepository.save(aluno);

	}

	@RabbitListener(queues = { "alunoDeletar" })
	public void deletarAluno(Aluno aluno) {

		Aluno alunoAchado = alunoRepository.getOne(aluno.getIdPessoa());

		alunoRepository.delete(aluno);

	}

}
