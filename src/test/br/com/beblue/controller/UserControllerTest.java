package br.com.beblue.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserControllerTest {
	
	protected WebApplicationContext context;
	
	protected RestTemplate restTemplate;
	
	protected MockMvc mockMvc;
	
	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
		mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.alwaysExpect(status().isOk())
				.alwaysExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.build();
	}

	@Test
	public void readUser() {
		String JSON = "[{" + 
							"\"user_cpf\": \"11111111111\"," +
							"\"name\": \"João Primeiro\"," +
							"\"balance\": 12" +
						"}, {" +
							"\"user_cpf\": \"22222222222\"," +
							"\"name\": \"Maria Segunda\"," +
							"\"balance\": 52.02" +
						"}, {" +
							"\"user_cpf\": \"33333333333\"," +
							"\"name\": \"Emerson Terceiro\"," +
							"\"balance\": 2.25" +
						"}, {" +
							"\"user_cpf\": \"44444444444\"," +
							"\"name\": \"Mario Quarto\"," +
							"\"balance\": 89.66" +
						"}]";
		String response = restTemplate.getForObject("localhost://beblue:8080/users", String.class);
		
		JSONAssert.assertEquals(JSON, response, true);
	}

}
