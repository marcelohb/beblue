package br.com.beblue.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	User usuario1;
	
	@Before
	public void setUp() {
		usuario1 = new User("11111111111", "Jack");
	}

	@Test
	public void igualdadeDeUsuarios() {
		User usuario2 = new User("11111111111", "Jack");
		assertEquals(usuario1, usuario2);
	}
	
	@Test
	public void novoUsuarioComSaldoZero() {
		assertEquals(Double.valueOf(0.0), usuario1.getBalance());
	}
	
	@Test
	public void ususarioNaoPodeTerSaldoNegativo() {
		usuario1.sacar(1.0d);
		assertEquals(Double.valueOf(0.0), usuario1.getBalance());
	}
	
	@Test
	public void depositar() {
		usuario1.depositar(10.0d);
		assertEquals(Double.valueOf(10.0), usuario1.getBalance());
	}

}
