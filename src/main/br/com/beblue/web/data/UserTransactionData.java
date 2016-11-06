package br.com.beblue.web.data;

import java.text.SimpleDateFormat;

import br.com.beblue.domain.Transaction;
import br.com.beblue.domain.User;

public class UserTransactionData {
	
	private String transaction_code;
	private String user_cpf;
	private String user_name;
	private Double user_balance;
	private String transaction_date;
	private String transaction_type;
	
	public UserTransactionData(Transaction t, User u) {
		this.transaction_code = t.getTransactionId().toString();
		this.user_cpf = u.getUser_cpf();
		this.user_name = u.getName();
		this.user_balance = u.getBalance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		this.transaction_date = sdf.format(t.getDate());
		this.transaction_type = t.getType().getTransaction_type();
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
	
	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Double getUser_balance() {
		return user_balance;
	}

	public void setUser_balance(Double user_balance) {
		this.user_balance = user_balance;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

}
