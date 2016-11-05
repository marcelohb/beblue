package br.com.beblue.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.beblue.AbstractTU;

public class TransactionControllerTest extends AbstractTU {
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.alwaysExpect(status().isOk())
				.alwaysExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.build();
	}
	
	@Test
	public void registerTransaction() throws Exception {
		String t1 = "{\"user_cpf\":\"11111111111\","
				+ "\"merchant_id\":\"1\","
				+ "\"transaction_value\":\"1.00\","
				+ "\"transaction_type\":\"TP_2\"}";

		mockMvc.perform(post("/register-transaction")
				.content(t1)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.success").value(true));
	}

}
