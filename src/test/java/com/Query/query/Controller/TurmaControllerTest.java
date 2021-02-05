package com.Query.query.Controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.query.query.model.Aluno;
import com.query.query.model.Disciplina;
import com.query.query.model.Professor;
import com.query.query.model.Turma;
import com.query.query.repository.AlunoRepository;
import com.query.query.repository.DisciplinaRepository;
import com.query.query.repository.ProfessorRepository;
import com.query.query.repository.TurmaRepository;
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class TurmaControllerTest {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ProfessorRepository professorRepository;

	@Test
	void retornaTurmaStatus200paraUmParametro() throws Exception {
		
		criarTurma();
		URI uri = new URI("/turma/1");

		mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.idTurma", is(1)))
				.andExpect(jsonPath("$.periodoLetivo", is(2)))
				.andExpect(jsonPath("$.numeroVagas", is(20)))
				.andExpect(jsonPath("$.anoLetivo", is("10")))
				.andExpect(jsonPath("$.descricao", is("5")))
				.andExpect(jsonPath("$.periodoLetivo", is(2)))
				.andExpect(jsonPath("$.disciplinas[*].idDisciplina",Matchers.containsInAnyOrder(1)))
				.andExpect(jsonPath("$.disciplinas[*].descricao",Matchers.containsInAnyOrder("desc")))
				.andExpect(jsonPath("$.disciplinas[*].cargaHoraria",Matchers.containsInAnyOrder("100")))
				.andExpect(jsonPath("$.disciplinas[*].sigla",Matchers.containsInAnyOrder("dis")))
				.andExpect(jsonPath("$.disciplinas[*].professores[*].idProfessor", Matchers.containsInAnyOrder(1)))
				.andExpect(jsonPath("$.disciplinas[*].professores[*].titulacao", Matchers.containsInAnyOrder("mestre")))
				.andExpect(jsonPath("$.disciplinas[*].professores[*].nome", Matchers.containsInAnyOrder("teste")))
				.andExpect(jsonPath("$.disciplinas[*].professores[*].email", Matchers.containsInAnyOrder("teste@teste")))
				.andExpect(jsonPath("$.disciplinas[*].professores[*].idPessoa", Matchers.containsInAnyOrder(1)))
				.andExpect(jsonPath("$.disciplinas[*].professores[*].cpf", Matchers.containsInAnyOrder("1111")))
				.andExpect(jsonPath("$.alunos[*].idPessoa",Matchers.containsInAnyOrder(1)))
				.andExpect(jsonPath("$.alunos[*].nome",Matchers.containsInAnyOrder("teste")))
				.andExpect(jsonPath("$.alunos[*].email",Matchers.containsInAnyOrder("teste@teste")))
				.andExpect(jsonPath("$.alunos[*].formaIngresso",Matchers.containsInAnyOrder("vestibular")))
				.andExpect(MockMvcResultMatchers.status()
				.is(200));
	}

	@Test
	public void retornaTurmaStatus200semParametro() throws Exception {
		
		criarTurma();
		
		URI uri = new URI("/turma");

		mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200))
				.andExpect(jsonPath("$.length()", is(1)))
				.andExpect(jsonPath("$.[0].idTurma", is(1)))
				.andExpect(jsonPath("$.[0].idTurma", is(1)))
				.andExpect(jsonPath("$.[0].periodoLetivo", is(2)))
				.andExpect(jsonPath("$.[0].numeroVagas", is(20)))
				.andExpect(jsonPath("$.[0].anoLetivo", is("10")))
				.andExpect(jsonPath("$.[0].descricao", is("5")))
				.andExpect(jsonPath("$.[0].periodoLetivo", is(2)))
				.andExpect(jsonPath("$.[0].disciplinas[*].idDisciplina",Matchers.containsInAnyOrder(1)))
				.andExpect(jsonPath("$.[0].disciplinas[*].descricao",Matchers.containsInAnyOrder("desc")))
				.andExpect(jsonPath("$.[0].disciplinas[*].cargaHoraria",Matchers.containsInAnyOrder("100")))
				.andExpect(jsonPath("$.[0].disciplinas[*].sigla",Matchers.containsInAnyOrder("dis")))
				.andExpect(jsonPath("$.[0].disciplinas[*].professor.idProfessor", Matchers.containsInAnyOrder(1)))
				.andExpect(jsonPath("$.[0].disciplinas[*].professor.titulacao", Matchers.containsInAnyOrder("mestre")))
				.andExpect(jsonPath("$.[0].disciplinas[*].professor.nome", Matchers.containsInAnyOrder("teste")))
				.andExpect(jsonPath("$.[0].disciplinas[*].professor.email", Matchers.containsInAnyOrder("teste@teste")))
				.andExpect(jsonPath("$.[0].disciplinas[*].professor.idPessoa", Matchers.containsInAnyOrder(1)))
				.andExpect(jsonPath("$.[0].disciplinas[*].professor.cpf", Matchers.containsInAnyOrder("1111")))
				.andExpect(jsonPath("$.[0].alunos[*].idPessoa",Matchers.containsInAnyOrder(1)))
				.andExpect(jsonPath("$.[0].alunos[*].nome",Matchers.containsInAnyOrder("teste")))
				.andExpect(jsonPath("$.[0].alunos[*].email",Matchers.containsInAnyOrder("teste@teste")))
				.andExpect(jsonPath("$.[0].alunos[*].formaIngresso",Matchers.containsInAnyOrder("vestibular")))
				.andExpect(MockMvcResultMatchers.status()
						.is(200));
				
	}
	
	private void criarTurma() {
		
		
		Set<Aluno> alunos = new HashSet<>();
		Aluno aluno = new Aluno(1,"teste","1111","teste@teste","vestibular");
		
		alunoRepository.saveAndFlush(aluno);
		
		alunos.add(aluno);
		
		Professor professor = new Professor(1,"teste","1111","teste@teste","mestre");
		
		professorRepository.saveAndFlush(professor);
		
		Set<Disciplina> disciplinas = new HashSet<>();
		Disciplina disciplina = new Disciplina(1,"desc","100","dis",professor);
		
		disciplinaRepository.saveAndFlush(disciplina);
		
		disciplinas.add(disciplina);
		
		Turma turma = new Turma(1, "10", "5", 20, 2, disciplinas, alunos);
		
		turmaRepository.saveAndFlush(turma);
		
	}
}
