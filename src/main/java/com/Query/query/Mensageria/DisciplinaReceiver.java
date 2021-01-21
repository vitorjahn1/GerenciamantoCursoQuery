package com.Query.query.Mensageria;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Query.query.Model.Disciplina;
import com.Query.query.Repository.DisciplinaRepository;

@Component
public class DisciplinaReceiver {

	@Autowired
	public DisciplinaRepository disciplinaRepository;

	@RabbitListener(queues = "disciplinaCriar")
	public void inserirTurma(Disciplina disciplina) {

		disciplinaRepository.save(disciplina);

	}

	@RabbitListener(queues = "disciplinaAtualizar")
	public void atualizarTurma(Disciplina disciplina) {

		Disciplina disciplinaAtualiza = disciplinaRepository.getOne(disciplina.getIdDisciplina());
		disciplinaAtualiza.setProfessoeres(disciplina.getProfessoeres());
		disciplinaAtualiza.setDescricao(disciplina.getDescricao());
		disciplinaAtualiza.setCargaHoraria(disciplina.getCargaHoraria());
		disciplinaAtualiza.setSigla(disciplina.getSigla());
		disciplinaAtualiza.setTurmas(disciplina.getTurmas());

		disciplinaRepository.save(disciplina);

	}

	@RabbitListener(queues = "disciplinaDeletar")
	public void deletarTurma(Disciplina disciplina) {

		disciplinaRepository.delete(disciplina);

	}

}
