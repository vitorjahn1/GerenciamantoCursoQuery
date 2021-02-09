package com.query.query.mensageria;

import javax.persistence.EntityNotFoundException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projetogerenciamentocurso.gerenciamentocurso.dto.DisciplinaDto;
import com.projetogerenciamentocurso.gerenciamentocurso.dto.ProfessorDto;
import com.query.query.exception.DisciplinaException;
import com.query.query.model.Disciplina;
import com.query.query.model.Professor;
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
		try {
			
			Disciplina disciplinaAtualiza = disciplinaRepository.getOne(disciplina.getIdDisciplina());
			disciplinaAtualiza.setIdDisciplina(disciplina.getIdDisciplina());
			disciplinaAtualiza.setDescricao(disciplina.getDescricao());
			disciplinaAtualiza.setCargaHoraria(disciplina.getCargaHoraria());
			disciplinaAtualiza.setSigla(disciplina.getSigla());
			if(disciplina.getProfessor()!= null)
				disciplinaAtualiza.setProfessor(criarModelProfessor(disciplina.getProfessor()));
			disciplinaRepository.save(disciplinaAtualiza);
		}catch (EntityNotFoundException e) {
			throw new DisciplinaException("Disciplina não encontrada");
		}
	}

	@RabbitListener(queues = "disciplinaDeletar")
	public void deletarDisciplina(DisciplinaDto disciplinaDto) {
		try {
			Disciplina disciplinaDeletar = disciplinaRepository.getOne(disciplinaDto.getIdDisciplina());
			
			disciplinaRepository.delete(disciplinaDeletar);
		}catch (EntityNotFoundException  e) {
			throw new DisciplinaException("Disciplina não encontrada");
		}
	}
	
	public Disciplina criarDisciplinaModel(DisciplinaDto disciplinaDto) {
		
		Disciplina disciplinaModel = new Disciplina();
		
		disciplinaModel.setIdDisciplina(disciplinaDto.getIdDisciplina());
		disciplinaModel.setDescricao(disciplinaDto.getDescricao());
		disciplinaModel.setCargaHoraria(disciplinaDto.getCargaHoraria());
		disciplinaModel.setSigla(disciplinaDto.getSigla());
		if(disciplinaDto.getProfessor()!= null)
			disciplinaModel.setProfessor(criarModelProfessor(disciplinaDto.getProfessor()));
		
		return disciplinaModel;
	}
	
	public Professor criarModelProfessor(ProfessorDto professorDto) {

		Professor criaProfessorModel = new Professor();

		criaProfessorModel.setCpf(professorDto.getCpf());
		criaProfessorModel.setEmail(professorDto.getEmail());
		criaProfessorModel.setNome(professorDto.getNome());
		criaProfessorModel.setTitulacao(professorDto.getTitulacao());
		criaProfessorModel.setIdProfessor(professorDto.getIdProfessor());
		criaProfessorModel.setIdPessoa(professorDto.getIdPessoa());
		
		
		return criaProfessorModel;
	}
}
