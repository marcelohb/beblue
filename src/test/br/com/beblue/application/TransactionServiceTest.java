package br.com.beblue.application;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.beblue.AbstractTU;
import br.com.beblue.domain.Transaction;
import br.com.beblue.web.data.TransactionData;

public class TransactionServiceTest extends AbstractTU {
	
	@Autowired
	private TransactionService service;
	
	private TransactionData td1;
	
	@Before
	public void setUp() {
		td1 = new TransactionData("11111111111", 1, 1.0d, "TP_2");
	}

	@Test
	public void registerTransaction() {
		service.registrerTransaction(td1);
		List<Transaction> transactions = service.getAll();
		assertEquals(1, transactions.size());
	}

}
