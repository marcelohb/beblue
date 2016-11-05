package br.com.beblue.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransactionTest {

	@Test
	public void newTransaction() {
		Transaction t = new Transaction(new User("11111111111", "Eu"), 
				new Merchant("Merchant Test"), 
				10.0d,
				new TransactionType("TP_1", "DEBITO"));
		assertEquals("Merchant Test", t.getMerchant().getName());
		assertEquals(Double.valueOf(10.0), t.getTransactionValue());
		assertEquals("TP_1", t.getType().getTransaction_type());
	}

}
