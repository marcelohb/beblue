package br.com.beblue.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Embedded
	private TransactionId transactionId;
	
	@ManyToOne
	@JoinColumn(name="user", referencedColumnName="id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="merchant", referencedColumnName="id")
	private Merchant merchant;
	
	private Double transactionValue;
	
	@ManyToOne
	@JoinColumn(name="type", referencedColumnName="id")
	private TransactionType type;
	
	private Date date;
	
	public Transaction(User user, Merchant merchant, Double transactionValue, TransactionType transactionType) {
		this.user = user;
		this.merchant = merchant;
		this.transactionValue = transactionValue;
		this.type = transactionType;
		this.transactionId = new TransactionId(UUID.randomUUID());
		this.date = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TransactionId getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(TransactionId transactionId) {
		this.transactionId = transactionId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Double getTransactionValue() {
		return transactionValue;
	}

	public void setTransactionValue(Double transactionValue) {
		this.transactionValue = transactionValue;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Transaction() {}

}
