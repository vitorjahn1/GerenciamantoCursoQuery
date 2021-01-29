package com.query.query.mensageria;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.query.query.dto.DisciplinaDto;
import com.query.query.exception.DisciplinaException;
import com.query.query.model.Disciplina;
import com.query.query.repository.DisciplinaRepository;

@Component
public class DisciplinaReceiver {

	@Autowired
	public DisciplinaRepository disciplinaRepository;

	@RabbitListener(queues = "disciplinaCriar")
	public void inserirDisciplina(DisciplinaDto disciplinaDto) {
		
		disciplinaRepository.save(criarDisciplinaModel(disciplinaDto));

	}

	@RabbitListener(queues = "disciplinaAtualizar")
	public void atualizarDisciplina(DisciplinaDto disciplina) {

		Disciplina disciplinaAtualiza = disciplinaRepository.getOne(disciplina.getIdDisciplina());
		if(disciplinaAtualiza != null) {
			disciplinaAtualiza.setProfessores(disciplina.getProfessores());
			disciplinaAtualiza.setDescricao(disciplina.getDescricao());
			disciplinaAtualiza.setCargaHoraria(disciplina.getCargaHoraria());
			disciplinaAtualiza.setSigla(disciplina.getSigla());
			disciplinaAtualiza.setTurmas(disciplina.getTurmas());

			disciplinaRepository.save(disciplinaAtualiza);
		}else {
			
			throw new DisciplinaException("Disciplina não encontrada");
		}

	}

	@RabbitListener(queues = "disciplinaDeletar")
	public void deletarTurma(DisciplinaDto disciplinaDto) {

		disciplinaRepository.delete(criarDisciplinaModel(disciplinaDto));

	}
	
	public Disciplina criarDisciplinaModel(DisciplinaDto disciplinaDto) {
		
		Disciplina disciplinaModel = new Disciplina();
		
		disciplinaModel.setProfessores(disciplinaDto.getProfessores());
		disciplinaModel.setDescricao(disciplinaDto.getDescricao());
		disciplinaModel.setCargaHoraria(disciplinaDto.getCargaHoraria());
		disciplinaModel.setSigla(disciplinaDto.getSigla());
		disciplinaModel.setTurmas(disciplinaDto.getTurmas());
		return disciplinaModel;
	}
}
