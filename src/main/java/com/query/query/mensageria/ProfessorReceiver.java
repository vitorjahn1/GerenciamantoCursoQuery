package com.query.query.mensageria;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projetogerenciamentocurso.gerenciamentocurso.dto.ProfessorDto;
import com.query.query.exception.ProfessorException;
import com.query.query.model.Professor;
import com.query.query.repository.ProfessorRepository;

@Component
@ResponseBody
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
			professorModel.setIdPessoa(professorDto.getIdPessoa());
			professorModel.setIdProfessor(professorDto.getIdProfessor());
			professorRepository.save(professorModel);
		}else {
			
			throw new ProfessorException("Professor não encotrado");
		}
	}

	@RabbitListener(queues = "professorDeletar")
	public void deletarProfessor(ProfessorDto professorDto) {

		Professor professorModel = professorRepository.findByIdProfessor(professorDto.getIdProfessor());

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
		professorModel.setIdPessoa(professorDto.getIdPessoa());
		professorModel.setIdProfessor(professorDto.getIdProfessor());
		return professorModel;
	}
}
