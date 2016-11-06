package br.com.beblue.application;

import static org.junit.Assert.*;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.beblue.AbstractTU;
import br.com.beblue.domain.Merchant;
import br.com.beblue.domain.Transaction;
import br.com.beblue.domain.User;
import br.com.beblue.repository.UserRepository;
import br.com.beblue.web.data.TransactionData;

public class UsersTransactionsServiceTest extends AbstractTU {
	
	@Autowired
	private TransactionService service;
	
	@Autowired
	private UserRepository userRepository;
	
	private TransactionData td1;
	private Merchant merchant;
	private User joao;
	
	@Before
	public void setUp() {
		td1 = new TransactionData("11111111111", 1, 1.0d, "TP_2");
		joao = new User(td1.getUser_cpf(), "Joao");
		merchant = new Merchant("Teste");
		merchant.setId(1);
		HashMap<DayOfWeek, Double> cashbacks = new HashMap<>();
		cashbacks.put(DayOfWeek.SUNDAY, 5d);
		cashbacks.put(DayOfWeek.MONDAY, 10d);
		cashbacks.put(DayOfWeek.TUESDAY, 15d);
		cashbacks.put(DayOfWeek.WEDNESDAY, 20d);
		cashbacks.put(DayOfWeek.THURSDAY, 25d);
		cashbacks.put(DayOfWeek.FRIDAY, 30d);
		cashbacks.put(DayOfWeek.SATURDAY, 35d);
		merchant.setCashbacks(cashbacks);
	}

	@Test
	public void registerCashBack() {
		userRepository.save(joao);
		service.registrerTransaction(td1);
		List<Transaction> transactions = service.getAll();
		joao = userRepository.findByUserCpf(td1.getUser_cpf());
		assertEquals(1, transactions.size());
		assertEquals(Double.valueOf(0.05), joao.getBalance());
	}

}
