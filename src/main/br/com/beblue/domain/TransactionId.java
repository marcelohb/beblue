package br.com.beblue.domain;

import java.util.UUID;

import javax.persistence.Embeddable;

@Embeddable
public class TransactionId {

	private UUID idTransaction;
	
	public TransactionId(UUID id) {
		this.idTransaction = id;
	}
	
	public UUID getIdTransaction() {
		return idTransaction;
	}
	
	public TransactionId() {}
	
	@Override
	public String toString() {
		return idTransaction.toString();
	}
}
