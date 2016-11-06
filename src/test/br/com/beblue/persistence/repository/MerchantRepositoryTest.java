package br.com.beblue.persistence.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.beblue.Application;
import br.com.beblue.domain.Merchant;
import br.com.beblue.repository.MerchantRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MerchantRepositoryTest {
	
	@Autowired
	private MerchantRepository repository;
	
	@Before
	public void setUp() {
		Merchant merchant = new Merchant("Estabelecimento de Teste");
		repository.save(merchant);
	}

	@Test
	public void buscar() {
		Merchant m = repository.findById(1);
		assertEquals("Estabelecimento de Teste", m.getName());
	}

}
