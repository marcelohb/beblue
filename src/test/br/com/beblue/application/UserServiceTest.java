package br.com.beblue.application;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.beblue.AbstractTU;
import br.com.beblue.domain.User;
import br.com.beblue.util.PreLoad;

public class UserServiceTest extends AbstractTU {
	
	@Autowired
	private UserService service;
	
	@Before
	public void setUp() {
		new PreLoad();
	}

	@Test
	public void getAll() {
		List<User> users = service.getAll();
		assertEquals(4, users.size());
	}

}
