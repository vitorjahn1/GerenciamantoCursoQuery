package com.query.query.mensageria;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.query.query.dto.ProfessorDto;
import com.query.query.exception.ProfessorException;
import com.query.query.model.Professor;
import com.query.query.repository.ProfessorRepository;

@Component
public class ProfessorReceiver {

	@Autowired
	public ProfessorRepository professorRepository;

	@RabbitListener(queues = "professorCriar")
	public void inserirProfessor(ProfessorDto professorDto) {

		professorRepository.save(criarProfessorModel(professorDto));

	}

	@RabbitListener(queues = "professorAtualizar")
	public void atualizarProfessor(ProfessorDto professorDto) {
		
		Professor professorModel = professorRepository.findByIdProfessor(professorDto.getIdProfessor());
		
		if(professorModel!= null) {
			professorModel.setCpf(professorDto.getCpf());
			professorModel.setEmail(professorDto.getEmail());
			professorModel.setNome(professorDto.getNome());
			professorModel.setTitulacao(professorDto.getTitulacao());
			professorRepository.save(professorModel);
		}else {
			
			throw new ProfessorException("Professor não encotrado");
		}
	}

	@RabbitListener(queues = "professorDeletar")
	public void deletarProfessor(ProfessorDto professorDto) {

		Professor professorModel = professorRepository.getOne(professorDto.getIdPessoa());

		if (professorModel != null) {
			professorRepository.delete(professorModel);
		}else {
			
			throw new ProfessorException("Professor não encotrado");
		}

	}

	public Professor criarProfessorModel(ProfessorDto professorDto) {

		Professor professorModel = new Professor();

		professorModel.setCpf(professorDto.getCpf());
		professorModel.setEmail(professorDto.getEmail());
		professorModel.setNome(professorDto.getNome());
		professorModel.setTitulacao(professorDto.getTitulacao());
		return professorModel;
	}
}
