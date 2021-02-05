package com.Query.query.Controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.net.URI;

import javax.transaction.Transactional;

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
class ProfessorControllerTest {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void retornaProfessorStatus200paraUmParametro() throws Exception {
		
		criarProfessor();
		
		URI uri = new URI("/professor/1");

		mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.idProfessor", is(1)))
		.andExpect(jsonPath("$.titulacao", is("mestre")))
		.andExpect(jsonPath("$.nome", is("teste")))
		.andExpect(jsonPath("$.email", is("teste@teste")))
		.andExpect(jsonPath("$.idPessoa", is(1)))
		.andExpect(jsonPath("$.cpf", is("1111")))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	void retornaProfessorStatus200semParametro() throws Exception {

		criarProfessor();
		
		URI uri = new URI("/professor");

		mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.length()", is(1)))
		.andExpect(jsonPath("$.[0].idProfessor", is(1)))
		.andExpect(jsonPath("$.[0].titulacao", is("mestre")))
		.andExpect(jsonPath("$.[0].nome", is("teste")))
		.andExpect(jsonPath("$.[0].email", is("teste@teste")))
		.andExpect(jsonPath("$.[0].idPessoa", is(1)))
		.andExpect(jsonPath("$.[0].cpf", is("1111")))
		.andExpect(MockMvcResultMatchers.status().is(200));		
	}
	
	private void criarProfessor(){
		
		Professor professor = new Professor(1,"teste","1111","teste@teste","mestre");
		
		professorRepository.saveAndFlush(professor);
		
		
		Disciplina disciplina = new Disciplina(1,"desc","100","dis",professor);
		
		disciplinaRepository.saveAndFlush(disciplina);
		
		
		
	}

}
