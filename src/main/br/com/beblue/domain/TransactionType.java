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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((transactionName == null) ? 0 : transactionName.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionType other = (TransactionType) obj;
		if (id != other.id)
			return false;
		if (transactionName == null) {
			if (other.transactionName != null)
				return false;
		} else if (!transactionName.equals(other.transactionName))
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		return true;
	}

	protected TransactionType() {}

}
