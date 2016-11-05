package br.com.beblue.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import br.com.beblue.AbstractTU;

public class UserControllerTest extends AbstractTU {
	
	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.alwaysExpect(status().isOk())
				.alwaysExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.build();
	}

	@Test
	public void readUser() {
		String JSON = "[{" + 
							"\"id\": 1," +
							"\"user_cpf\": \"11111111111\"," +
							"\"name\": \"João Primeiro\"," +
							"\"balance\": 12" +
						"}, {" +
							"\"id\": 2," +
							"\"user_cpf\": \"22222222222\"," +
							"\"name\": \"Maria Segunda\"," +
							"\"balance\": 52.02" +
						"}, {" +
							"\"id\": 3," +
							"\"user_cpf\": \"33333333333\"," +
							"\"name\": \"Emerson Terceiro\"," +
							"\"balance\": 2.25" +
						"}, {" +
							"\"id\": 4," +
							"\"user_cpf\": \"44444444444\"," +
							"\"name\": \"Mario Quarto\"," +
							"\"balance\": 89.66" +
						"}]";
		String response = restTemplate.getForObject("http://localhost:8080/users", String.class);
		
		JSONAssert.assertEquals(JSON, response, true);
	}

}
