package br.com.beblue.repository;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.beblue.Application;
import br.com.beblue.domain.User;
import br.com.beblue.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	private RestTemplate restTemplate;
	
	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
		User[] users = restTemplate.getForObject("https://quarkbackend.com/getfile/vilibaldo-neto/json-javatest-users", User[].class);
		repository.deleteAll();
		for (User u : users) {
			repository.save(u);
		}
	}

	@Test
	public void loadUser() {
		assertEquals(4,repository.count());
	}
	
	@Test
	public void findByCpf() {
		User u = repository.findByUserCpf("11111111111");
		assertEquals("11111111111", u.getUser_cpf());
		assertEquals("João Primeiro", u.getName());
		assertEquals(Double.valueOf(12.0), u.getBalance());
	}
	
	@Test
	public void findById() {
		User u = repository.findById(1);
		assertEquals("11111111111", u.getUser_cpf());
		assertEquals("João Primeiro", u.getName());
		assertEquals(Double.valueOf(12.0), u.getBalance());
	}

}
