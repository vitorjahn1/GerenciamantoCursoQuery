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

import com.query.query.model.Disciplina;
import com.query.query.model.Professor;
import com.query.query.repository.DisciplinaRepository;
import com.query.query.repository.ProfessorRepository;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class DisciplinaControllerTest {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void retornaAlunoStatus200paraUmParametro() throws Exception {
		
		criarDisciplina();
		
		URI uri = new URI("/disciplina/1");
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.idDisciplina",is(1)))
		.andExpect(jsonPath("$.descricao",is("desc")))
		.andExpect(jsonPath("$.cargaHoraria",is("100")))
		.andExpect(jsonPath("$.sigla",is("dis")))
		.andExpect(jsonPath("$.professores[*].idProfessor", Matchers.containsInAnyOrder(1)))
		.andExpect(jsonPath("$.professores[*].titulacao", Matchers.containsInAnyOrder("mestre")))
		.andExpect(jsonPath("$.professores[*].nome", Matchers.containsInAnyOrder("teste")))
		.andExpect(jsonPath("$.professores[*].email", Matchers.containsInAnyOrder("teste@teste")))
		.andExpect(jsonPath("$.professores[*].idPessoa", Matchers.containsInAnyOrder(1)))
		.andExpect(jsonPath("$.professores[*].cpf", Matchers.containsInAnyOrder("1111")))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	void retornaAlunoStatus200semParametro() throws Exception {
		criarDisciplina();
		
		URI uri = new URI("/disciplina");

		mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.length()",is(1)))
		.andExpect(jsonPath("$.[0].idDisciplina",is(1)))
		.andExpect(jsonPath("$.[0].descricao",is("desc")))
		.andExpect(jsonPath("$.[0].cargaHoraria",is("100")))
		.andExpect(jsonPath("$.[0].sigla",is("dis")))		
		.andExpect(jsonPath("$.[0].professores[*].idProfessor", Matchers.containsInAnyOrder(1)))
		.andExpect(jsonPath("$.[0].professores[*].titulacao", Matchers.containsInAnyOrder("mestre")))
		.andExpect(jsonPath("$.[0].professores[*].nome", Matchers.containsInAnyOrder("teste")))
		.andExpect(jsonPath("$.[0].professores[*].email", Matchers.containsInAnyOrder("teste@teste")))
		.andExpect(jsonPath("$.[0].professores[*].idPessoa", Matchers.containsInAnyOrder(1)))
		.andExpect(jsonPath("$.[0].professores[*].cpf", Matchers.containsInAnyOrder("1111")))
		.andExpect(MockMvcResultMatchers.status().is(200));

	}

	private void criarDisciplina() {
		
		Professor professor = new Professor(1,"teste","1111","teste@teste","mestre");
		
		professorRepository.saveAndFlush(professor);
		
		Set<Professor> professores = new HashSet<>();

		professores.add(professor);
		
		Disciplina disciplina = new Disciplina(1,"desc","100","dis",professores);
		
		disciplinaRepository.saveAndFlush(disciplina);
		
	}
	
}
