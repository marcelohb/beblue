package br.com.beblue.reposiroty;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import br.com.beblue.domain.User;

public class UserRepositoryTest {
	
	@Autowired
	UserRepository repository;
	
	private RestTemplate restTemplate;
	
	List<User> users;
	
	String JSON = "[{ " +
		"\"user_cpf\": \"11111111111\", " +
		"\"name\": \"João Primeiro\", " + 
		"\"balance\": 12" +
	"}, {" +
	"	\"user_cpf\": \"22222222222\"," +
	"	\"name\": \"Maria Segunda\"," +
	"	\"balance\": 52.02" +
	"}, {" +
	"	\"user_cpf\": \"33333333333\"," +
	"	\"name\": \"Emerson Terceiro\"," +
	"	\"balance\": 2.25" +
	"}, {" +
	"	\"user_cpf\": \"44444444444\"," +
	"	\"name\": \"Mario Quarto\"," +
	"	\"balance\": 89.66" +
	"}]";
	
	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
		List<User> users = (List<User>) restTemplate.getForObject("https://quarkbackend.com/getfile/vilibaldo-neto/json-javatest-users", User.class);
		repository.save(users);
	}

	@Test
	public void loadUser() {
		
	}

}
