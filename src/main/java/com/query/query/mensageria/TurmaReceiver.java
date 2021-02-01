package com.query.query.mensageria;

import javax.persistence.EntityNotFoundException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.query.query.dto.TurmaDto;
import com.query.query.exception.TurmaException;
import com.query.query.model.Turma;
import com.query.query.repository.TurmaRepository;

@Component
public class TurmaReceiver {

	@Autowired
	public TurmaRepository turmaRepository;

	@RabbitListener(queues = "turmaCriar")
	public void inserirTurma(TurmaDto turmaDto) {

		turmaRepository.save(criarTurmaModel(turmaDto));

	}

	@RabbitListener(queues = "turmaAtualizar")
	public void atualizarTurma(TurmaDto turmaDto) {
		try {
			Turma turmaModel = turmaRepository.getOne(turmaDto.getIdTurma());
			turmaModel.setAlunos(turmaDto.getAlunos());
			turmaModel.setAnoLetivo(turmaDto.getAnoLetivo());
			turmaModel.setDescricao(turmaDto.getDescricao());
			turmaModel.setNumeroVagas(turmaDto.getNumeroVagas());
			turmaModel.setPeriodoLetivo(turmaDto.getPeriodoLetivo());
			turmaRepository.save(turmaModel);
		}catch (EntityNotFoundException  e) {
			throw new TurmaException("Turma não encontrada");
		}
	}

	@RabbitListener(queues = "turmaDeletar")
	public void deletarTurma(TurmaDto turmaDto) {
		
		try {
			Turma turmaModel = turmaRepository.getOne(turmaDto.getIdTurma());
			
			turmaRepository.delete(turmaModel);
		}catch (EntityNotFoundException e) {
			throw new TurmaException("Turma não encontrada");
		}
	}
	
	public Turma criarTurmaModel(TurmaDto turmaDto) {
		
		Turma turmaModel = new Turma();
		
		turmaModel.setAlunos(turmaDto.getAlunos());
		turmaModel.setAnoLetivo(turmaDto.getAnoLetivo());
		turmaModel.setDescricao(turmaDto.getDescricao());
		turmaModel.setNumeroVagas(turmaDto.getNumeroVagas());
		turmaModel.setPeriodoLetivo(turmaDto.getPeriodoLetivo());
		
		return turmaModel;
		
	}
}
