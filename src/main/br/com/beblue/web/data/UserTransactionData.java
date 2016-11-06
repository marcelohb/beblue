package br.com.beblue.web.data;

import java.util.Date;

import br.com.beblue.domain.Transaction;
import br.com.beblue.domain.TransactionType;
import br.com.beblue.domain.User;

public class UserTransactionData {
	
	private String transaction_code;
	private String user_cpf;
	private Double user_balance;
	private Date transaction_date;
	private TransactionType transaction_type;
	
	public UserTransactionData(Transaction t, User u) {
		this.transaction_code = t.getTransactionId().toString();
		this.user_cpf = u.getUser_cpf();
		this.user_balance = u.getBalance();
		this.transaction_date = t.getDate();
		this.transaction_type = t.getType();
	}

	public String getTransaction_code() {
		return transaction_code;
	}

	public void setTransaction_code(String transaction_code) {
		this.transaction_code = transaction_code;
	}

	public String getUser_cpf() {
		return user_cpf;
	}

	public void setUser_cpf(String user_cpf) {
		this.user_cpf = user_cpf;
	}

	public Double getUser_balance() {
		return user_balance;
	}

	public void setUser_balance(Double user_balance) {
		this.user_balance = user_balance;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	public TransactionType getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(TransactionType transaction_type) {
		this.transaction_type = transaction_type;
	}

}
