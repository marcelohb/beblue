package br.com.beblue.domain;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class UsersTransactionsTest {
	
	private User u;
	private Transaction t;
	private Merchant m;
	private HashMap<DayOfWeek, Double> cashbacks;
	private UsersTransactions transactions;
	
	@Before
	public void setUp() {
		u = new User("11111111111", "Eu");
		u.setId(1);
		transactions = new UsersTransactions();
		m = new Merchant("Merchant Test");
		m.setId(1);
		cashbacks = new HashMap<>();
		cashbacks.put(DayOfWeek.SUNDAY, 5d);
		cashbacks.put(DayOfWeek.MONDAY, 10d);
		cashbacks.put(DayOfWeek.TUESDAY, 15d);
		cashbacks.put(DayOfWeek.WEDNESDAY, 20d);
		cashbacks.put(DayOfWeek.THURSDAY, 25d);
		cashbacks.put(DayOfWeek.FRIDAY, 30d);
		cashbacks.put(DayOfWeek.SATURDAY, 35d);
		m.setCashbacks(cashbacks);
		t = new Transaction(u, m,10.0d, new TransactionType("TP_1", "CASHBACK"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void registerTransactionCashBackSemSaldo() {
		assertEquals("Merchant Test", t.getMerchant().getName());
		assertEquals(Double.valueOf(10.0), t.getTransactionValue());
		assertEquals("TP_1", t.getType().getTransaction_type());
		transactions.registerTransaction(t, t.getMerchant());
		assertEquals(Double.valueOf(0.0), transactions.getUser(1).getBalance());
	}
	
	@Test
	public void registerTransactionDebitoSemSaldo() throws ParseException {
		Transaction t2 = new Transaction(u, m, 10.0d, new TransactionType("TP_2", "DEBITO"));
		t2.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("06-11-2016"));
		transactions.registerTransaction(t2, t2.getMerchant());
		assertEquals(Double.valueOf(0.5), transactions.getUser(1).getBalance());
	}
	
	@Test
	public void registerTransactionDebitoECredito() throws ParseException {
		Transaction t2 = new Transaction(u, m, 10.0d, new TransactionType("TP_2", "DEBITO"));
		t2.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("06-11-2016"));
		Transaction t3 = new Transaction(u, m, 5.1d, new TransactionType("TP_3", "CREDITO"));
		t3.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("06-11-2016"));
		transactions.registerTransaction(t2, t2.getMerchant());
		transactions.registerTransaction(t3, t3.getMerchant());
		assertEquals(Double.valueOf(0.755), transactions.getUser(1).getBalance());
	}
	
	@Test
	public void registerTransactionDebitoECashback() throws ParseException {
		Transaction t2 = new Transaction(u, m, 10.0d, new TransactionType("TP_2", "DEBITO"));
		t2.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("06-11-2016"));
		Transaction t3 = new Transaction(u, m, 5.0d, new TransactionType("TP_1", "CASHBACK"));
		t3.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("06-11-2016"));
		transactions.registerTransaction(t2, t2.getMerchant());
		transactions.registerTransaction(t3, t3.getMerchant());
		assertEquals(Double.valueOf(0.25), transactions.getUser(1).getBalance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void registerTransactionUsarMaisQueSaldo() throws ParseException {
		Transaction t2 = new Transaction(u, m, 10.0d, new TransactionType("TP_2", "DEBITO"));
		t2.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("06-11-2016"));
		Transaction t3 = new Transaction(u, m, 15.0d, new TransactionType("TP_1", "CASHBACK"));
		t3.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("06-11-2016"));
		transactions.registerTransaction(t2, t2.getMerchant());
		transactions.registerTransaction(t3, t3.getMerchant());
		assertEquals(Double.valueOf(0.0), transactions.getUser(1).getBalance());
	}

}
