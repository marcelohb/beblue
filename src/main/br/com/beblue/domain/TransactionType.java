package br.com.beblue.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String transactionType;
	private String transactionName;
	
	public TransactionType(String type, String name) {
		transactionType = type;
		transactionName = name;
	}
	
	public String getTransaction_type() {
		return transactionType;
	}

	public String getTransaction_name() {
		return transactionName;
	}

	protected TransactionType() {}

}
