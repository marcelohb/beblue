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

import br.com.beblue.domain.TransactionType;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TransactionTypeTest {
	
	@Autowired
	private TransactionTypeRepository repository;
	
	private RestTemplate restTemplate;
	
	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
		TransactionType[] types = restTemplate.getForObject("https://quarkbackend.com/getfile/vilibaldo-neto/json-javatest-transactiontypr", TransactionType[].class);
		for (TransactionType t : types) {
			repository.save(t);
		}
	}

	@Test
	public void load() {
		assertEquals(3, repository.count());
	}
	
	@Test
	public void findByType() {
		TransactionType t = repository.findByTransactionType("TP_1");
		assertEquals("TP_1", t.getTransaction_type());
		assertEquals("CASHBACK", t.getTransaction_name());
	}

}
