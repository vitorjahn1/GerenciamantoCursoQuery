package com.Query.query.Mensageria;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Query.query.Model.Turma;
import com.Query.query.Repository.TurmaRepository;

@Component
public class TurmaReceiver {

	@Autowired
	public TurmaRepository turmaRepository;

	@RabbitListener(queues = "turmaCriar")
	public void inserirTurma(Turma turma) {

		turmaRepository.save(turma);

	}

	@RabbitListener(queues = "turmaAtualizar")
	public void atualizarTurma(Turma turma) {

		turmaRepository.save(turma);

	}

	@RabbitListener(queues = "turmaDeletar")
	public void deletarTurma(Turma turma) {

		turmaRepository.delete(turma);

	}

}
