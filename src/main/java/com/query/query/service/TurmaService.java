package com.query.query.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.projetogerenciamentocurso.gerenciamentocurso.dto.AlunoDto;
import com.projetogerenciamentocurso.gerenciamentocurso.dto.DisciplinaDto;
import com.projetogerenciamentocurso.gerenciamentocurso.dto.TurmaDto;
import com.query.query.dtoresposta.AlunoDtoResposta;
import com.query.query.dtoresposta.DisciplinaDtoResposta;
import com.query.query.dtoresposta.TurmaDtoResposta;
import com.query.query.exception.TurmaException;
import com.query.query.model.Aluno;
import com.query.query.model.Disciplina;
import com.query.query.model.Turma;
import com.query.query.repository.TurmaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class TurmaService {

	private final TurmaRepository turmaRepository;
	
	private final DisciplinaService disciplinaService;
	
	private final AlunoService alunoService;
	
	public TurmaDtoResposta retornaTurma(Integer idTurma) {

		Turma turmaRetorno = turmaRepository.findByIdTurma(idTurma);

		if (turmaRetorno == null)
			throw new TurmaException("Turma não encontrada");

		return criarTurmaDtoResposta(turmaRetorno);
	}

	public List<TurmaDtoResposta> retornaTurma() {

		List<TurmaDtoResposta> turmasDtoResposta = new ArrayList<>();

		for (Turma turma : turmaRepository.findAll()) {

			if (turma == null) {
				continue;
			}

			turmasDtoResposta.add(criarTurmaDtoResposta(turma));
		}

		return turmasDtoResposta;
	}

	public TurmaDto criarTurmaDto(Turma turma) {

		TurmaDto turmaDto = new TurmaDto();
		if(turma.getAlunos()!=null)
			turmaDto.setAlunos(criaListaAlunoDto(turma.getAlunos()));
		turmaDto.setAnoLetivo(turma.getAnoLetivo());
		turmaDto.setDescricao(turma.getDescricao());
		turmaDto.setNumeroVagas(turma.getNumeroVagas());
		turmaDto.setPeriodoLetivo(turma.getPeriodoLetivo());
		turmaDto.setIdTurma(turma.getIdTurma());
		if(turma.getDisciplinas()!=null)
			turmaDto.setDisciplinas(criaListaDisciplinaDto(turma.getDisciplinas()));
		return turmaDto;

	}
	
	private Set<AlunoDto> criaListaAlunoDto(Set<Aluno> alunos){
		Set<AlunoDto> alunosDto = new HashSet<>();
		if(alunos!= null && !alunos.isEmpty()) {
			
			for(Aluno aluno : alunos){
				
				alunosDto.add(alunoService.criarAlunoDto(aluno));
			}
			return alunosDto;
		}else {
			return alunosDto;
		}
		
	}
	
	private Set<DisciplinaDto> criaListaDisciplinaDto(Set<Disciplina> disciplinas){
		Set<DisciplinaDto> disciplinasDto = new HashSet<>();
		if(disciplinas!= null && !disciplinas.isEmpty()) {
			
			for(Disciplina disciplina: disciplinas){
				
				disciplinasDto.add(disciplinaService.criarDisciplinaDto(disciplina));
			}
			return disciplinasDto;
		}else {
			return disciplinasDto;
		}
		
	}
	
	private Set<DisciplinaDtoResposta> criaListaDisciplinaDtoResposta(Set<Disciplina> disciplinas){
		Set<DisciplinaDtoResposta> disciplinasDtoResposta = new HashSet<>();
		if(disciplinas!= null && !disciplinas.isEmpty()) {
			
			for(Disciplina disciplina: disciplinas){
				
				disciplinasDtoResposta.add(disciplinaService.criarDisciplinaDtoResposta(disciplina));
			}
			return disciplinasDtoResposta;
		}else {
			return disciplinasDtoResposta;
		}
		
	}
	
	private Set<AlunoDtoResposta> criaListaAlunoDtoResposta(Set<Aluno> alunos){
		Set<AlunoDtoResposta> alunosDtoResposta = new HashSet<>();
		if(alunos!= null && !alunos.isEmpty()) {
			
			for(Aluno aluno : alunos){
				
				alunosDtoResposta.add(alunoService.criarAlunoDtoResposta(aluno));
			}
			return alunosDtoResposta;
		}else {
			return alunosDtoResposta;
		}
		
	}
	
	public TurmaDtoResposta criarTurmaDtoResposta(Turma turma) {

		TurmaDtoResposta turmaDtoResposta = new TurmaDtoResposta();
		if(turma.getAlunos()!=null)
			turmaDtoResposta.setAlunos(criaListaAlunoDtoResposta(turma.getAlunos()));
		turmaDtoResposta.setAnoLetivo(turma.getAnoLetivo());
		turmaDtoResposta.setDescricao(turma.getDescricao());
		turmaDtoResposta.setNumeroVagas(turma.getNumeroVagas());
		turmaDtoResposta.setPeriodoLetivo(turma.getPeriodoLetivo());
		turmaDtoResposta.setIdTurma(turma.getIdTurma());
		if(turma.getDisciplinas()!=null)
			turmaDtoResposta.setDisciplinas(criaListaDisciplinaDtoResposta(turma.getDisciplinas()));
		return turmaDtoResposta;

	}
}
