package com.Query.query.Controller;

import java.net.URI;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.query.query.model.Disciplina;
import com.query.query.repository.DisciplinaRepository;

@SpringBootTest
@AutoConfigureMockMvc
class DisciplinaControllerTest {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void retornaAlunoStatus200paraUmParametro() throws Exception {
		
		try {
			disciplinaRepository.getOne(1);
			
			URI uri = new URI("/disciplina/1");
			
			mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(200));
		
		}catch (Exception e) {
			System.out.println("entrou.............");
			Disciplina disciplina = new Disciplina(1, null, null, null, null, null);
			disciplinaRepository.save(disciplina);
			
			URI uri = new URI("/disciplina/1");
			
			mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(200));
		}
		
	}

	@Test
	public void retornaAlunoStatus200semParametro() throws Exception {

		URI uri = new URI("/disciplina");

		mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}


}
