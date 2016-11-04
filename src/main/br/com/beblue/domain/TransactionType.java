package br.com.beblue.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="transaction_type")
	private String transactionType;
	
	@Column(name="transaction_name")
	private String transactionName;
	
	public TransactionType(String type, String name) {
		transactionType = type;
		transactionName = name;
	}
	
	public String getTransaction_type() {
		return transactionType;
	}
	
	public void setTransaction_type(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransaction_name() {
		return transactionName;
	}
	
	public void setTransaction_name(String transactionName) {
		this.transactionName = transactionName;
	}

	protected TransactionType() {}

}
