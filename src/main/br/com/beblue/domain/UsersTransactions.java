package br.com.beblue.domain;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class UsersTransactions {
	@Id
	private int id;
	
	private int userId;
	private String transactionId;
	
	@Transient
	private static HashMap<Integer, User> users = new HashMap<>();
	
	@Transient
	private static HashMap<TransactionId, Transaction> transactions = new HashMap<>();

	public void registerTransaction(Transaction t, Merchant m) {
		Double value = t.getTransactionValue();
		if ("TP_1".equals(t.getType().getTransaction_type())) {
			t.getUser().sacar(value);
		} else {
			value = t.getTransactionValue() * (m.getCashBackFromString(t.getDayOfWeek())/100);
			t.getUser().depositar(value);
		}
		userId = t.getUser().getId();
		transactionId = t.getTransactionId().toString();
		transactions.put(t.getTransactionId(), t);
		users.put(t.getUser().getId(), t.getUser());
	}

	public User getUser(Integer i) {
		return users.get(i);
	}
	
	public static HashMap<TransactionId, Transaction> getTransactions() {
		return transactions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public UsersTransactions() {}

}
