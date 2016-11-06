package br.com.beblue.domain;

import java.util.HashMap;

public class UsersTransactions {
	
	private static HashMap<Integer, User> users = new HashMap<>();
	private static HashMap<TransactionId, Transaction> transactions = new HashMap<>();
	
	public UsersTransactions() {
	}

	public void registerTransaction(Transaction t) {
		if ("TP_1".equals(t.getType().getTransaction_type())) {
			t.getUser().sacar(t.getTransactionValue());
		} else {
			t.getUser().depositar(t.getTransactionValue());
		}
		transactions.put(t.getTransactionId(), t);
		users.put(t.getUser().getId(), t.getUser());
	}

	public User getUser(Integer i) {
		return users.get(i);
	}
	
	public static HashMap<TransactionId, Transaction> getTransactions() {
		return transactions;
	}

}
