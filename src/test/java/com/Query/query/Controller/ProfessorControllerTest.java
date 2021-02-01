package com.Query.query.Controller;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ProfessorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void retornaProfessorStatus200paraUmParametro() throws Exception {

		URI uri = new URI("/professor/1");

		mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}

	@Test
	public void retornaProfessorStatus200semParametro() throws Exception {

		URI uri = new URI("/professor");

		mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}

}
