package br.com.beblue.domain;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

public class TransactionIdTest {

	@Test
	public void newId() {
		TransactionId id = new TransactionId(UUID.randomUUID());
		assertNotNull(id.getIdTransaction());
	}
	
	@Test
	public void differentId() {
		TransactionId id1 = new TransactionId(UUID.randomUUID());
		TransactionId id2 = new TransactionId(UUID.randomUUID());
		assertNotEquals(id1.getIdTransaction(), id2.getIdTransaction());
	}

}
