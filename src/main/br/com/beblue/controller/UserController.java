package br.com.beblue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beblue.application.UserService;
import br.com.beblue.domain.User;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/users")
	public List<User> users() {
		return userService.getAll();
	}
	

}
