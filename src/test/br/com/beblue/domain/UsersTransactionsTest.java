package br.com.beblue.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UsersTransactionsTest {
	
	private User u;
	private Transaction t;
	private UsersTransactions transactions;
	
	@Before
	public void setUp() {
		u = new User("11111111111", "Eu");
		u.setId(1);
		transactions = new UsersTransactions();
		t = new Transaction(u, 
				new Merchant("Merchant Test"), 
				10.0d,
				new TransactionType("TP_1", "CASHBACK"));
	}

	@Test
	public void registerTransactionCashBackSemSaldo() {
		assertEquals("Merchant Test", t.getMerchant().getName());
		assertEquals(Double.valueOf(10.0), t.getTransactionValue());
		assertEquals("TP_1", t.getType().getTransaction_type());
		transactions.registerTransaction(t);
		assertEquals(Double.valueOf(0.0), transactions.getUser(1).getBalance());
	}
	
	@Test
	public void registerTransactionDebitoSemSaldo() {
		Transaction t2 = new Transaction(u, 
				new Merchant("Merchant Test"), 
				10.0d,
				new TransactionType("TP_2", "DEBITO"));
		transactions.registerTransaction(t2);
		assertEquals(Double.valueOf(10.0), transactions.getUser(1).getBalance());
	}
	
	@Test
	public void registerTransactionDebitoECredito() {
		Transaction t2 = new Transaction(u, 
				new Merchant("Merchant Test"), 
				10.0d,
				new TransactionType("TP_2", "DEBITO"));
		Transaction t3 = new Transaction(u, 
				new Merchant("Merchant Test"), 
				5.1d,
				new TransactionType("TP_3", "CREDITO"));
		transactions.registerTransaction(t2);
		transactions.registerTransaction(t3);
		assertEquals(Double.valueOf(15.1), transactions.getUser(1).getBalance());
	}
	
	@Test
	public void registerTransactionDebitoECashback() {
		Transaction t2 = new Transaction(u, 
				new Merchant("Merchant Test"), 
				10.0d,
				new TransactionType("TP_2", "DEBITO"));
		Transaction t3 = new Transaction(u, 
				new Merchant("Merchant Test"), 
				5.0d,
				new TransactionType("TP_1", "CASHBACK"));
		transactions.registerTransaction(t2);
		transactions.registerTransaction(t3);
		assertEquals(Double.valueOf(5.0), transactions.getUser(1).getBalance());
	}
	
	@Test
	public void registerTransactionUsarMaisQueSaldo() {
		Transaction t2 = new Transaction(u, 
				new Merchant("Merchant Test"), 
				10.0d,
				new TransactionType("TP_2", "DEBITO"));
		Transaction t3 = new Transaction(u, 
				new Merchant("Merchant Test"), 
				15.0d,
				new TransactionType("TP_1", "CASHBACK"));
		transactions.registerTransaction(t2);
		transactions.registerTransaction(t3);
		assertEquals(Double.valueOf(0.0), transactions.getUser(1).getBalance());
	}

}
