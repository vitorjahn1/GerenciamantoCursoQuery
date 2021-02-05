package com.Query.query.Controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.net.URI;

import javax.transaction.Transactional;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.query.query.model.Aluno;
import com.query.query.repository.AlunoRepository;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class AlunoControllerTest {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void retornaAlunoStatus200paraUmParametro() throws Exception {
		
		criarAluno();
		
		URI uri = new URI("/aluno/1");

		mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.idPessoa",is(1)))
		.andExpect(jsonPath("$.nome",is("teste")))
		.andExpect(jsonPath("$.email",is("teste@teste")))
		.andExpect(jsonPath("$.formaIngresso",is("vestibular")))
		.andExpect(jsonPath("$.matricula",is(1)))
		.andExpect(MockMvcResultMatchers.status()
				.is(200));

	}

	@Test
	void retornaAlunoStatus200semParametro() throws Exception {
		criarAluno();
		
		URI uri = new URI("/aluno");

		mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.length()",is(1)))
		.andExpect(jsonPath("$.[0].idPessoa",is(1)))
		.andExpect(jsonPath("$.[0].nome",is("teste")))
		.andExpect(jsonPath("$.[0].email",is("teste@teste")))
		.andExpect(jsonPath("$.[0].formaIngresso",is("vestibular")))
		.andExpect(jsonPath("$.[0].matricula",is(1)))
		.andExpect(MockMvcResultMatchers.status().is(200));

	}
	
	private void criarAluno() {
		
		Aluno aluno = new Aluno(1, "teste", "1111", "teste@teste", "vestibular");
		
		alunoRepository.saveAndFlush(aluno);
		
	}

}
