package com.example.demoJPA.UNIT;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demoJPA.controller.MainController;
import com.example.demoJPA.entity.Persona;
import com.example.demoJPA.service.PersonaService;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MainControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PersonaService personaService;

	Optional<Persona> personaMock = personaService.getPersonaByDni("41004940b");

	@Test
	public void obtenerPersonaDni() throws Exception {

		Mockito.when(

				personaService.getPersonaByDni("41004940b")).thenReturn(personaMock);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/personas/41004940b")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:Course1,name:Spring,description:10 Steps}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K
		// Students","steps":["Learn Maven","Import Project","First Example","Second
		// Example"]}

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

//		Mockito.when(personaService.getPersonaByDni("41004040b")).thenReturn(personaMock);
//
//		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/personas")
//				.accept(MediaType.APPLICATION_JSON);

	}
}
