package br.com.beblue.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beblue.domain.User;
import br.com.beblue.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> getAll() {
		return (List<User>) repository.findAll();
	}

	public User findByCpf(String cpf) {
		return repository.findByUserCpf(cpf);
	}

}
